package com.example.api.service.user;


import com.example.api.dto.user.UserRequestDto;
import com.example.api.model.User;


public interface UserService {


    User createNewUser(UserRequestDto dto);

    User saveUser(User user);

    User getUser(Long userId);
}
