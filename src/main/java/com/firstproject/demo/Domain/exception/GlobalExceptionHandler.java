package com.firstproject.demo.Domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
        log.error("Student not found exception occurred");
        ResponseEntity<String> responseEntity = new ResponseEntity<>(studentNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException bookNotFoundException){
        log.error("Book not found exception occurred");
        ResponseEntity<String> responseEntity = new ResponseEntity<>(bookNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

}
