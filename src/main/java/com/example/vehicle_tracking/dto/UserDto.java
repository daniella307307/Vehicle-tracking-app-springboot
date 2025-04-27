package com.example.vehicle_tracking.dto;

import com.example.vehicle_tracking.model.Vehicle;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class UserDto {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
