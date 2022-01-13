package com.example.api.service.user;


import com.example.api.dto.user.UserRequestDto;
import com.example.api.model.User;

import java.util.List;


public interface UserService {


    User createNewUser(UserRequestDto dto);

    User saveUser(User user);

    User getUser(Long userId);

    List<User> getAllUserInfo();

    List<User> findPagingUser(int n1, int n2);

    User getUserByEmail(String email);
}
