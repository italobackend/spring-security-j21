package com.italobackend.springsecurityloginj21.controller;

import com.italobackend.springsecurityloginj21.dto.request.LoginRequest;
import com.italobackend.springsecurityloginj21.dto.request.RegisterRequest;
import com.italobackend.springsecurityloginj21.dto.response.UserResponse;
import com.italobackend.springsecurityloginj21.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> userCreate(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.from(service.userCreate(request)));
    }
}
