package com.example.vehicle_tracking.controller;

import com.example.vehicle_tracking.dto.AuthDto;
import com.example.vehicle_tracking.dto.AuthResponse;
import com.example.vehicle_tracking.dto.UserDto;
import com.example.vehicle_tracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthDto request){
        return ResponseEntity.ok(userService.authenticate(request));
    }
}
