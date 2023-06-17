package nastia.dev.somnus.service;

import nastia.dev.somnus.model.Dream;
import nastia.dev.somnus.model.User;
import nastia.dev.somnus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User newUser){
        if (userRepository.findByUsername(newUser.getUsername()) == null){
            return userRepository.save(newUser);
        }
        return null;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).get();
    }

    public void addUserDream(User user, Dream dream) {
        user.getDreams().add(dream);
    }

    public Set<Dream> getUserDreams(Long userId){
        return userRepository.findById(userId).get().getDreams();
    }
}
