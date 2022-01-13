package com.example.api.controller;

import com.example.api.dto.LoginDto;
import com.example.api.dto.TokenDto;
import com.example.api.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping()
    public String logIn(@RequestBody LoginDto dto){
        return loginService.createTokenDto(dto);
    }

}
