package com.firstproject.demo.Application.controllers;

import com.firstproject.demo.Application.dto.StudentGeneralDto;
import com.firstproject.demo.Domain.entity.Student;
import com.firstproject.demo.Domain.service.StudentService;
import com.firstproject.demo.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/getStudent/{id}")
    public String getStudent(@PathVariable Integer id){
            return id.toString();
    }

}
