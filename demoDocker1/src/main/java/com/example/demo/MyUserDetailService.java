package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userService.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }

        return new User(user.login(), user.password(), getAuthorities(user.role()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role){
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
