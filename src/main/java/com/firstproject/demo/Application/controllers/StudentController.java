package com.firstproject.demo.Application.controllers;

import com.firstproject.demo.Application.dto.request.CreateStudentDto;
import com.firstproject.demo.Application.dto.response.StudentGeneralDto;
import com.firstproject.demo.Domain.entity.Student;
import com.firstproject.demo.Domain.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentGeneralDto> getStudent(@RequestParam Integer id){
        return studentService.getStudent(id);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStdent(@RequestBody CreateStudentDto createStudentDto){
        return studentService.addStudent(createStudentDto);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestParam Integer id, @RequestParam String newName){
        return studentService.updateStudent(id,newName);
    }
}
