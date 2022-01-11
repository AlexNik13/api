package com.example.api.repository.spring;

import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryString extends JpaRepository<User, Long> {

    Optional<User> findStudentByEmail(String email);
}