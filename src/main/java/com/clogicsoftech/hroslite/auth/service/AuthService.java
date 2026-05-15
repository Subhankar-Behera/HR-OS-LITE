package com.clogicsoftech.hroslite.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clogicsoftech.hroslite.auth.dto.AuthResponse;
import com.clogicsoftech.hroslite.auth.dto.LoginRequest;
import com.clogicsoftech.hroslite.auth.dto.RegisterRequest;

import com.clogicsoftech.hroslite.auth.entity.User;
import com.clogicsoftech.hroslite.auth.repository.UserRepository;
import com.clogicsoftech.hroslite.security.JwtService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String registerUser(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {

            return "Email already exists";

        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return "User Saved Successfully";

    }

    public AuthResponse loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {

            return new AuthResponse("Invalid Email");

        }

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {

            return new AuthResponse("Invalid Password");

        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token);

    }

}