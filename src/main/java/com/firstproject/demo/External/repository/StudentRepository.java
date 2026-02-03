package com.firstproject.demo.External.repository;

import com.firstproject.demo.Domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer>{
    Optional<Student> findByName(String name);
    List<Student> findByGradeIn(List<Integer> grade);
}
