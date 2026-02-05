package com.firstproject.demo.Application.dto.response;

import lombok.Data;
import com.firstproject.demo.Domain.entity.Role;

@Data
public class StudentGeneralDto {
    private Integer id;
    private String name;
    private Integer grade;
    private String email;
    private String address;
    private Role role;


}
