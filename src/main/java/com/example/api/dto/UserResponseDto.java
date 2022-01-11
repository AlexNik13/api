package com.example.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String password;
}
