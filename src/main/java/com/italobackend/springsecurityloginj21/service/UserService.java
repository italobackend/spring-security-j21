package com.italobackend.springsecurityloginj21.service;

import com.italobackend.springsecurityloginj21.domain.User;
import com.italobackend.springsecurityloginj21.dto.request.RegisterRequest;
import com.italobackend.springsecurityloginj21.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User userCreate(RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This username has already been registered.");
        }
        User user = new User(request.name(), request.username(), passwordEncoder.encode(request.password()));
        return userRepository.save(user);

    }
}
