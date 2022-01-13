package com.example.api.controller;


import com.example.api.dto.user.UserRequestDto;
import com.example.api.dto.user.UserResponseDto;
import com.example.api.mapper.UserMapper;
import com.example.api.model.User;
import com.example.api.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/new")
    public UserResponseDto createNewUser(@RequestBody UserRequestDto dto){
        User user = userService.createNewUser(dto);
        return UserMapper.toUserResponseDto(user);
    }


    @GetMapping("/profile/{userId}")
    public UserResponseDto getUserInfo(@PathVariable Long userId){
        User user = userService.getUser(userId);
        return UserMapper.toUserResponseDto(user);
    }

    @GetMapping("/profile")
    public List<UserResponseDto>  getAllUserInfo(){
        List<User> users = userService.getAllUserInfo();

        return UserMapper.toAllUserResponseDto(users);
    }

    @GetMapping("/profile/{n1}/{n2}")
    public List<UserResponseDto>  getPagingUserInfo(@PathVariable int n1,
                                                    @PathVariable int n2){
        List<User> users = userService.findPagingUser(n1, n2);

        return UserMapper.toAllUserResponseDto(users);
    }
}
