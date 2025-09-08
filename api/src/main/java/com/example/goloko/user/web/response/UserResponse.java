package com.example.goloko.user.web.response;

import com.example.goloko.user.domain.User;

public record UserResponse(
        Long id,
        String email,
        String firstName,
        String lastName
){}
