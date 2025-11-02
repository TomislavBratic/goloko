package com.example.goloko.auth;

import com.example.goloko.user.application.UserService;
import com.example.goloko.user.web.request.CreateUserRequest;
import com.example.goloko.user.web.request.LoginRequest;
import com.example.goloko.user.web.response.LoginResponse;
import com.example.goloko.user.web.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService){
        this.authService = authService;
        this.userService = userService;

    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody CreateUserRequest request){
        UserResponse saved = userService.create(request);
        return ResponseEntity.created(URI.create("/api/users/" + saved.id()))
                .body(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        LoginResponse saved = authService.login(request);
        return ResponseEntity.created(URI.create("/api/auth/login" ))
                .body(saved);
    }
}
