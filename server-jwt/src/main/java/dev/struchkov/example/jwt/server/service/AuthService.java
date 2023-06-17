package dev.struchkov.example.jwt.server.service;


import dev.struchkov.example.jwt.server.domain.JwtAuthentication;
import dev.struchkov.example.jwt.server.domain.JwtRequest;
import dev.struchkov.example.jwt.server.domain.JwtResponse;
import dev.struchkov.example.jwt.server.domain.User;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final Map<String, String> refreshStorage = new HashMap<>(); //redis
    private final JwtProvider jwtProvider;


    public JwtResponse login(@NonNull JwtRequest authRequest) throws AuthException {
        final User user = userService.getByLogin(authRequest.getLogin())
                .orElseThrow(() -> new AuthException("User is not found"));
        if (user.getPassword().equals(authRequest.getPassword())){
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getLogin(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        }else{
            throw new AuthException("Wrong password");
        }
    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)){
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)){
                final User user = userService.getByLogin(login)
                        .orElseThrow(() -> new AuthException("User is not found"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)){
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)){
                final User user = userService.getByLogin(login)
                        .orElseThrow(() -> new AuthException("User is not found"));

                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(login, newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Invalid Jwt token");
    }

    public JwtAuthentication getAuthInfo(){
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

}
