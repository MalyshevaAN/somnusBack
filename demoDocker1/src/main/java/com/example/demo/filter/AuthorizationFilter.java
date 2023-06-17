package com.example.demo.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class AuthorizationFilter extends BasicAuthenticationFilter {
    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("jwtToken");

        if (header == null){
            chain.doFilter(request, response);
        }

        UsernamePasswordAuthenticationToken token = checkAuth(request);
        SecurityContextHolder.getContext().setAuthentication(token);


        super.doFilterInternal(request, response, chain);
    }

    private UsernamePasswordAuthenticationToken checkAuth(HttpServletRequest request){
        String token  = request.getHeader("jwtToken");
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("failed lecture".getBytes()))
                .build()
                .verify(token);

        String login = decodedJWT.getSubject();
        if (login != null){
            return new UsernamePasswordAuthenticationToken(login, null, Collections.emptyList());
        }
        return null;
    }

}
