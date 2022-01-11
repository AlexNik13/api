package com.example.api.dto.admin;


import com.example.api.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminUserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
