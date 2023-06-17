package nastia.demoAuthorization.service;

import nastia.demoAuthorization.model.Role;
import nastia.demoAuthorization.model.User;
import nastia.demoAuthorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user == null) throw  new UsernameNotFoundException(email);

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        for (Role role : user.getRoles()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), grantedAuthoritySet);
    }
}
