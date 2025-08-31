package com.example.goloko.user.application;

import com.example.goloko.user.domain.Role;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.domain.UserRepository;
import com.example.goloko.user.web.request.CreateUserRequest;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
@Transactional
    public User create(CreateUserRequest req)
    {
        if(userRepository.existsByEmail(req.email()))
        {
            throw new IllegalArgumentException("Email already in use");
        }
        User user = new User();
        user.setEmail(req.email().trim());
        user.setPasswordHash(encoder.encode(req.password()));
        user.setFirstName(req.firstName().trim());
        user.setLastName(req.lastName().trim());
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public Optional<User> get(Long id)
    {
      return userRepository.findById(id);
    }
}
