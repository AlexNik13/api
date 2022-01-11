package com.example.api.service.admin;

import com.example.api.repository.UserRepositoryImpl;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class AdminControllerImpl implements AdminController {

    private final UserRepositoryImpl userRepository;

    public AdminControllerImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }



}
