package com.example.api.service.user;

import com.example.api.dto.user.UserRequestDto;
import com.example.api.model.User;
import com.example.api.repository.UserRepositoryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));

        return saveUser(user);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.getUserById(userId);
        return null;
    }
}
