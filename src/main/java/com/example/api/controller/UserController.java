package com.example.api.controller;


import com.example.api.dto.UserRequestDto;
import com.example.api.dto.UserResponseDto;
import com.example.api.model.User;
import com.example.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

/*
    @PutMapping
    public UserResponseDto createNewUser(@RequestBody UserRequestDto dto){
        User user = userService.createNewUser(dto);
    }*/

}
