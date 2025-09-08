package com.example.goloko.user.application;

import com.example.goloko.user.domain.Role;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.domain.UserRepository;
import com.example.goloko.user.web.mapper.UserMapper;
import com.example.goloko.user.web.request.CreateUserRequest;
import com.example.goloko.user.web.response.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
@Transactional
    public UserResponse create(CreateUserRequest request)
    {
        if(userRepository.existsByEmail(request.email()))
        {
            throw new IllegalArgumentException("Email already in use");
        }
        User user = userMapper.toEntity(request);
        user.setPasswordHash(encoder.encode(request.password()));
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public Optional<UserResponse> get(Long id)
    {
      return userRepository.findById(id).map(userMapper::toUserResponse);
    }
}
