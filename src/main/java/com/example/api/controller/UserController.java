package com.example.api.controller;


import com.example.api.dto.user.UserRequestDto;
import com.example.api.dto.user.UserResponseDto;
import com.example.api.mapper.UserMapper;
import com.example.api.model.User;
import com.example.api.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PutMapping
    public UserResponseDto createNewUser(@RequestBody UserRequestDto dto){
        User user = userService.createNewUser(dto);
        return UserMapper.toUserResponseDto(user);
    }


    @GetMapping("/profile/{userId}")
    public UserResponseDto getUserInfo(@PathVariable Long userId){
        User user = userService.getUser(userId);
        return UserMapper.toUserResponseDto(user);
    }
}
