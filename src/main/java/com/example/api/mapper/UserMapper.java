package com.example.api.mapper;

import com.example.api.dto.admin.AdminUserResponseDto;
import com.example.api.dto.user.UserResponseDto;
import com.example.api.model.User;

public class UserMapper {

    public static UserResponseDto toUserResponseDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }

    public static AdminUserResponseDto toAdminUserResponseDto(User user){

        AdminUserResponseDto dto = new AdminUserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }
}
