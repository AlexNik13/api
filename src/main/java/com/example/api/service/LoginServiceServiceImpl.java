package com.example.api.service;

import com.example.api.dto.LoginDto;
import com.example.api.dto.TokenDto;
import com.example.api.model.User;
import com.example.api.security.jwt.JwtTokenProvider;
import com.example.api.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    public LoginServiceServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }


    @Override
    public String createTokenDto(LoginDto dto) {
        
        String email = dto.getEmail();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, dto.getPassword()));
        
        User user = userService.getUserByEmail(email);
        
        if(user == null){
            throw new UsernameNotFoundException("User with user email: " + email + " not found");
        }
        
        String token = tokenProvider.createToken(email, user.getRole());


        
        
        return token;
    }
}
