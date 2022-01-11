package com.example.api.controller;

import com.example.api.dto.admin.AdminUserResponseDto;
import com.example.api.dto.user.UserResponseDto;
import com.example.api.mapper.UserMapper;
import com.example.api.model.User;
import com.example.api.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/profile/{userId}")
    public AdminUserResponseDto getUserInfo(@PathVariable Long userId){
        User user = userService.getUser(userId);
        return UserMapper.toAdminUserResponseDto(user);
    }
}
