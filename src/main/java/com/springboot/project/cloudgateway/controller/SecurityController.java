package com.springboot.project.cloudgateway.controller;

import com.springboot.project.cloudgateway.security.JWTUtil;
import com.springboot.project.cloudgateway.security.PBKDF2Encoder;
import com.springboot.project.cloudgateway.security.model.AuthRequest;
import com.springboot.project.cloudgateway.security.model.AuthResponse;
import com.springboot.project.cloudgateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class SecurityController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PBKDF2Encoder passwordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/welcome")
    public String getInitialMessage() {
        return "Welcome to the Hotel Reservation System";
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
        return userService.findByUsername(ar.getUsername()).map((userDetails) -> {
            if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
                return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
