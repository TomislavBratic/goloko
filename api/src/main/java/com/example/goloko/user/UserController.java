package com.example.goloko.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    public UserController(UserRepository userRepository, UserService userService)
    {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserResponse>createUser(@Valid @RequestBody CreateUserRequest request){
        User saved = userService.create(request);
        return ResponseEntity.created(URI.create("/api/users/" + saved.getId()))
                .body(UserResponse.from(saved));

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>getUser(@PathVariable Long id)
    {
        return ResponseEntity.of(userService.get(id).map(UserResponse::from));
    }
}
