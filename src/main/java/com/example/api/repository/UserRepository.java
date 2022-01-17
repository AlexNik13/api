package com.example.api.repository;

import com.example.api.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User getUserById(Long userId);

    User getUserByEmail(String username);

    List<User> findAllUser();

    List<User> findPagingUser(int n1, int n2);

    User findUser(String name);
}
