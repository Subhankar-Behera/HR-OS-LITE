package com.clogicsoftech.hroslite.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.clogicsoftech.hroslite.auth.dto.LoginRequest;

import com.clogicsoftech.hroslite.auth.dto.RegisterRequest;

import com.clogicsoftech.hroslite.auth.service.AuthService;
import com.clogicsoftech.hroslite.auth.dto.AuthResponse;

@RestController

@RequestMapping("/auth")

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {

        this.authService = authService;

    }

    @PostMapping("/register")

    public String register(@RequestBody RegisterRequest request) {

        return authService.registerUser(request);

    }

    @PostMapping("/login")

    public AuthResponse login(@RequestBody LoginRequest request) {

        return authService.loginUser(request);

    }

}