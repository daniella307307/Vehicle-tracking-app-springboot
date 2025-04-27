package com.example.vehicle_tracking.service;

import com.example.vehicle_tracking.dto.AuthDto;
import com.example.vehicle_tracking.dto.AuthResponse;
import com.example.vehicle_tracking.dto.UserDto;
import com.example.vehicle_tracking.model.User;
import com.example.vehicle_tracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    private Date date;

    public AuthResponse saveUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPassword(userDto.getPassword());
        user.setCreatedAt(new Date());
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token,"User Created Successfully");
    }
    public AuthResponse authenticate(AuthDto authDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword())
        );

            User user =userRepository.findByEmail(authDto.getEmail()).orElseThrow(()->new RuntimeException("User not found"));
            String token = jwtService.generateToken(user);
            return  new AuthResponse(token,"Logged in successfully");

    }
}
