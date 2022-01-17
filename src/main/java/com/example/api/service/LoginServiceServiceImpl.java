package com.example.api.service;

import com.example.api.dto.LoginDto;
import com.example.api.model.User;
import com.example.api.security.jwt.JwtTokenProvider;
import com.example.api.service.user.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;
    private final PasswordEncoder encoder;

    public LoginServiceServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserService userService, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
        this.encoder = encoder;
    }


    @Override
    public String createTokenDto(LoginDto dto) {

        String email = dto.getEmail();
        User user = userService.getUserByEmail(email);

        if (encoder.matches(dto.getPassword(), user.getPassword())) {
            System.out.println("wrongCredentials.password");

        }

        String token = tokenProvider.createToken(email, user.getRole());


        return token;
    }
}
