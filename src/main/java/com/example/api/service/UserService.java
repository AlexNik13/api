package com.example.api.service;


import com.example.api.dto.UserRequestDto;
import com.example.api.model.User;
import org.springframework.stereotype.Service;


public interface UserService {


    User createNewUser(UserRequestDto dto);
}
