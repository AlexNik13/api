package com.example.api.repository;

import com.example.api.repository.spring.UserRepositoryString;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryString userRepository;

    public UserRepositoryImpl(UserRepositoryString userRepository) {
        this.userRepository = userRepository;
    }
}
