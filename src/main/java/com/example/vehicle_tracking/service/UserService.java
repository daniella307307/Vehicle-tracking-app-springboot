package com.example.vehicle_tracking.service;

import com.example.vehicle_tracking.dto.AuthDto;
import com.example.vehicle_tracking.dto.UserDto;
import com.example.vehicle_tracking.model.User;
import com.example.vehicle_tracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder

    private Date date;

    public User saveUser(UserDto userDto){
        User user= new User();
        user.setEmail(userDto.getEmail());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setVehicle(userDto.getVehicle());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);
        return user;
    }

    public String login(AuthDto authDto){
        User user= userRepository.findByEmail(authDto.getEmail());
        return "User authenticated";
    }
}
