package dev.struchkov.example.jwt.server.domain;


import lombok.Getter;
import lombok.Setter;



// класс, который пользователь будет присылать, чтобы получить JWT токен
@Getter
@Setter
public class JwtRequest {

    private String login;
    private String password;

}
