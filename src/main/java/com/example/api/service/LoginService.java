package com.example.api.service;

import com.example.api.dto.LoginDto;
import com.example.api.dto.TokenDto;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    String createTokenDto(LoginDto dto);
}
