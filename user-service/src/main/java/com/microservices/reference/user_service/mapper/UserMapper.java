package com.microservices.reference.user_service.mapper;

import com.microservices.reference.user_service.domain.User;
import com.microservices.reference.user_service.dto.UserDTOs;

public class UserMapper {
    public static UserDTOs.Response toDto(User u) {
        return UserDTOs.Response.builder()
                .id(u.getId())
                .name(u.getName())
                .email(u.getEmail())
                .build();
    }
}
