package com.firstproject.demo.Domain.service;

import com.firstproject.demo.Domain.dto.ResponseDto;
import com.firstproject.demo.Domain.dto.UserDto;
import com.firstproject.demo.Domain.entity.User;
import com.firstproject.demo.Domain.repository.AuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public User findUserByEmail(String email) {
        return authRepository.findByEmail(email);
    }

    @Transactional(rollbackFor = {Exception.class})
    public ResponseDto signUp(UserDto userDto) {
        User existingUser = findUserByEmail(userDto.getEmail());
        if (existingUser != null) {
            log.info("{} tried to sign up again", userDto.getEmail());
            return new ResponseDto("500", "That email is taken. Try another one!");
        } else {
            String verifyCode = String.valueOf(100000 + new Random().nextInt(900000));

            User user = modelMapper.map(userDto, User.class);
            user.setActive(true);
            user.setVerified(false);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setVerifyCode(verifyCode);
            user.setCreateDateTime(new Date());
            authRepository.save(user);
            return new ResponseDto("200", "success");
        }
    }
}
