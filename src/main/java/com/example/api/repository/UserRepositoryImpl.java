package com.example.api.repository;

import com.example.api.model.User;
import com.example.api.repository.spring.UserRepositoryString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public User getUserByEmail(String email) {
        User user = delegate.findByEmail(email).orElseThrow(
                NoSuchElementException::new
        );

        return user;
    }

    @Override
    public List<User> findAllUser() {

        Pageable first = Pageable.ofSize(5);


        Page<User> users = delegate.findAll(first);

        return users.stream().toList();
    }

    @Override
    public List<User> findPagingUser(int n1, int n2) {

        Pageable first = PageRequest.of(n1, n2);


        Page<User> users = delegate.findAll(first);

        return users.stream().toList();
    }
}
