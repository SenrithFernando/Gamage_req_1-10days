package com.firstproject.demo.Domain.service;

import com.firstproject.demo.Application.dto.request.CreateStudentDto;
import com.firstproject.demo.Application.dto.response.StudentGeneralDto;
import com.firstproject.demo.Domain.entity.Student;
import com.firstproject.demo.Domain.exception.StudentNotFoundException;
import com.firstproject.demo.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    public ResponseEntity<StudentGeneralDto> getStudent(Integer id){
        StudentGeneralDto studentGeneralDto = new StudentGeneralDto();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentGeneralDto.setId(student.getId());
            studentGeneralDto.setName(student.getName());
            studentGeneralDto.setEmail(student.getEmail());
            studentGeneralDto.setGrade(student.getGrade());
            studentGeneralDto.setRole(student.getRole());
            return ResponseEntity.ok(studentGeneralDto);
        }else{
            throw new StudentNotFoundException("Student not found");
        }
    }

    public ResponseEntity<Student> addStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        student.setName(createStudentDto.getName());
        student.setAddress(createStudentDto.getAddress());
        student.setEmail(createStudentDto.getEmail());
        student.setGrade(createStudentDto.getGrade());
        student.setPassword(createStudentDto.getPassword());
        student.setRole(createStudentDto.getRole());
        studentRepository.save(student);
        ResponseEntity<Student> responseEntity = ResponseEntity.ok(student);
        return responseEntity;
    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted Successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<java.util.List<StudentGeneralDto>> getAllStudent() {
        java.util.List<Student> students = studentRepository.findAll();
        java.util.List<StudentGeneralDto> studentGeneralDtos = students.stream().map(student -> {
            StudentGeneralDto dto = new StudentGeneralDto();
            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setEmail(student.getEmail());
            dto.setGrade(student.getGrade());
            dto.setRole(student.getRole());
            return dto;
        }).collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(studentGeneralDtos);
    }

    public ResponseEntity<String> updateStudent(Integer id, CreateStudentDto updateDto) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            log.info("Student found and the id is {}", id);
            Student student = optionalStudent.get();
            student.setName(updateDto.getName());
            student.setAddress(updateDto.getAddress());
            student.setEmail(updateDto.getEmail());
            student.setGrade(updateDto.getGrade());
            student.setPassword(updateDto.getPassword());
            student.setRole(updateDto.getRole());
            studentRepository.save(student);
            return ResponseEntity.ok("Student updated successfully");
        }else{
            throw new StudentNotFoundException("Student not found");
        }
    }
}
