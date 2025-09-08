package com.example.goloko.user.web.mapper;

import com.example.goloko.user.domain.User;
import com.example.goloko.user.web.request.CreateUserRequest;
import com.example.goloko.user.web.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User request);

    @Mapping(target = "email", expression = "java(request.email().trim())")
    @Mapping(target = "firstName", expression = "java(request.firstName().trim())")
    @Mapping(target = "lastName", expression = "java(request.lastName().trim())")
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(CreateUserRequest request);

}
