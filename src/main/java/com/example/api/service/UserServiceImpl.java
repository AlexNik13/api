package com.example.api.service;

import com.example.api.dto.UserRequestDto;
import com.example.api.model.User;
import com.example.api.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(UserRequestDto dto) {
        return null;
    }
}
