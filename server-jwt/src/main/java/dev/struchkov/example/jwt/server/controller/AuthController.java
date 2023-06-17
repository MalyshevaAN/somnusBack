package dev.struchkov.example.jwt.server.controller;


import dev.struchkov.example.jwt.server.service.AuthService;
import dev.struchkov.example.jwt.server.domain.JwtRequest;
import dev.struchkov.example.jwt.server.domain.JwtResponse;
import dev.struchkov.example.jwt.server.domain.RefreshJwtRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;

@RestController
@RequestMapping("api/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) throws AuthException {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final  JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}
