package com.example.vehicle_tracking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String manufacturer;
    private String year;
    private String model;
    @ManyToOne
    private String owner;
}
