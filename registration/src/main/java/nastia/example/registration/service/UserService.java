package nastia.example.registration.service;

import nastia.example.registration.model.AuthorizeData;
import nastia.example.registration.model.SimpleUser;
import nastia.example.registration.repository.SimpleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    SimpleUserRepository repository;
    public Optional<SimpleUser> get(String email){
        return repository.findByEmail(email);
    }

    private boolean check(String email){
        return repository.findByEmail(email).isEmpty();
    }
    public Optional<SimpleUser> get(Long id){
        return repository.findById(id);
    }


    public String create(SimpleUser user){
        if (!check(user.getEmail())){
            return "this email is already authorized, try to login";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            return "password are different";
        }
        repository.save(user);
        return "Registration is successful!";
    }

    public Optional<SimpleUser> authorize(AuthorizeData data){
        if (repository.findByEmail(data.getEmail()).isEmpty()){
            return Optional.empty();
        }
        if (!repository.findByEmail(data.getEmail()).get().getPassword().equals(data.getPassword())){
            return Optional.empty();
        }
        return Optional.of(repository.findByEmail(data.getEmail()).get());
    }

}
