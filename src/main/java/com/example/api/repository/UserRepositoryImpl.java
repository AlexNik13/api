package com.example.api.repository;

import com.example.api.model.User;
import com.example.api.repository.spring.UserRepositoryString;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryString delegate;

    public UserRepositoryImpl(UserRepositoryString delegate) {
        this.delegate = delegate;
    }

    @Override
    public User save(User user) {
        return delegate.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        User user = delegate.findById(userId).orElseThrow (
                NoSuchElementException::new
        );
        return user;
    }
}
