package com.firstproject.demo.Domain.service;

import com.firstproject.demo.Domain.entity.User;
import com.firstproject.demo.Domain.repository.AuthRepository;
import com.firstproject.demo.Domain.exception.UserNotActiveException;
import com.firstproject.demo.Domain.exception.UserNotVerifiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, UserNotActiveException, UserNotVerifiedException {
        User user = authRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        if (user.getActive() != null && !user.getActive()) {
            throw new UserNotActiveException();
        }
        if (user.getVerified() != null && !user.getVerified()) {
            throw new UserNotVerifiedException();
        }

        List<GrantedAuthority> listAuthorities = new ArrayList<>();
        if (user.getRole() != null) {
            listAuthorities.add(new com.firstproject.demo.Config.Role(user.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), listAuthorities);
    }
}
