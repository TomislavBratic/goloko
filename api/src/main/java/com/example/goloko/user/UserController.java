package com.example.goloko.user;

import com.example.goloko.user.application.UserService;
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
        UserResponse saved = userService.create(request);
        return ResponseEntity.created(URI.create("/api/users/" + saved.id()))
                .body(saved);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>getUser(@PathVariable Long id)
    {
        return ResponseEntity.of(userService.get(id));
    }
}
