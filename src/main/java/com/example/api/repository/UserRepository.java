package com.example.api.repository;

import com.example.api.model.User;

public interface UserRepository {
    User save(User user);

    User getUserById(Long userId);

    User getUserByEmail(String username);
}
