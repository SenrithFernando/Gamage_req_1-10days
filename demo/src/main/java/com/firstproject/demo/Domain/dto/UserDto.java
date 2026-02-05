package com.firstproject.demo.Domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
}
