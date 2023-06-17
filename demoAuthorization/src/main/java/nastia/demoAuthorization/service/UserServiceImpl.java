package nastia.demoAuthorization.service;

import jakarta.transaction.Transactional;
import nastia.demoAuthorization.model.Role;
import nastia.demoAuthorization.model.User;
import nastia.demoAuthorization.repository.RoleRepository;
import nastia.demoAuthorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
