package com.firstproject.demo.Domain.repository;

import com.firstproject.demo.Domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findFirstByEmailAndActiveTrueAndVerifiedTrue(String email);
}
