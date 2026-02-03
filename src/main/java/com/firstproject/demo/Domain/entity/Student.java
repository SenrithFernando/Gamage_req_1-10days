package com.firstproject.demo.Domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Student {
    @Id
    private Integer id;
    private String name;
    private String address;
    private String email;
    private Integer grade;
    private Date dob;
    private String password;


}



