package com.example.goloko.user;

public record UserResponse(
        String email,
        String firstName,
        String lastName
)
{
    public static UserResponse from(User user){
        return new UserResponse(user.getEmail(),user.getFirstName(),user.getLastName());
    }

}
