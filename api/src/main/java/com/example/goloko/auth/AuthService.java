package com.example.goloko.auth;

import com.example.goloko.auth.Jwt.JwtService;
import com.example.goloko.user.domain.Role;
import com.example.goloko.user.web.request.LoginRequest;
import com.example.goloko.user.web.response.LoginResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
//We need to break circular dependency between AuthService and Security Config
    public AuthService(@Lazy AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();

        String token = jwtService.generateTokenFromUserDetails(user);

        String roleName = user.getAuthorities().iterator().next().getAuthority();
        Role role = Role.valueOf(roleName);

        return new LoginResponse(token, user.getUsername(), role);
    }
}