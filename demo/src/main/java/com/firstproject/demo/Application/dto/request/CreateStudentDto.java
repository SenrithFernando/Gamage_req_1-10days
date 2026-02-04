package com.firstproject.demo.Application.dto.request;

import lombok.Data;
import com.firstproject.demo.Domain.entity.Role;

@Data
public class CreateStudentDto {
    private String name;
    private String address;
    private String email;
    private Integer grade;
    private String password;
    private Role role;
}
