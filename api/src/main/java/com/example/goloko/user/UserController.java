package com.example.goloko.user;

import com.example.goloko.user.application.UserService;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.web.request.CreateUserRequest;
import com.example.goloko.user.web.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService)
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
