package dev.struchkov.example.jwt.server.service;

import dev.struchkov.example.jwt.server.domain.Role;
import dev.struchkov.example.jwt.server.domain.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final List<User> users;

    public UserService(){

        this.users = List.of(
                new User("anton", "1234","ANTON", "IVANOV", Collections.singleton(Role.USER)),
                new User("ivan", "12345", "SERGEY", "SERGEEV", Collections.singleton(Role.ADMIN))
        );
    }

    public Optional<User> getByLogin(@NonNull String login){
        return users.stream().filter(user-> user.getLogin().equals(login)).findFirst();
    }
}
