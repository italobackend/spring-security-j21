package com.italobackend.springsecurityloginj21.dto.response;

import com.italobackend.springsecurityloginj21.domain.User;

public record UserResponse(
        Long id,
        String name,
        String username,
        String role
) {

    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getUsername(), user.getRole().name());
    }
}
