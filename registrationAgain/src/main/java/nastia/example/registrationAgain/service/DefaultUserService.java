package nastia.example.registrationAgain.service;


import nastia.example.registrationAgain.model.UserData;
import nastia.example.registrationAgain.model.UserEntity;
import nastia.example.registrationAgain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.stereotype.Service;


@Service("userService")
public class DefaultUserService implements UserServise {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(UserData user) throws Exception {
        if(checjIfUserExists(user.getEmail())){
            throw new Exception("User already Exists");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);

    }

    @Override
    public boolean checjIfUserExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity user) {

    }

    @Override
    public boolean verifyUser(String token) throws InvalidCsrfTokenException {
        return false;
    }

    @Override
    public UserEntity getUserById(String id) throws UnknownError {
        return null;
    }

    private void encodePassword(UserEntity userEntity, UserData user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}

