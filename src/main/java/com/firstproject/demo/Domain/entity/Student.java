package com.firstproject.demo.Domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Student {
    @Id
    private int id;
    private String name;
    private String address;
    private String email;
    private String grade;

    public Student(String name, int id, String address, String email, String grade) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.email = email;
        this.grade = grade;
    }

}



