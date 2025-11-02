package com.example.goloko.user.web.response;


import com.example.goloko.user.domain.Role;

public record LoginResponse(
        String token,
        String email,
        Role role
) {
}
