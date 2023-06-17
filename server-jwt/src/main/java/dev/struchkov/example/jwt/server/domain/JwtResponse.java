package dev.struchkov.example.jwt.server.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

    private final String type="Bearer";
    private String accessToken;
    private String refreshToken;

}
