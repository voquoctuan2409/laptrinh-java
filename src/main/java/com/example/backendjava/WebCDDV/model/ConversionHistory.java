package com.example.backendjava.WebCDDV.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConversionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // "distance", "weight", "temperature"
    private double value;
    private String fromUnit;
    private String toUnit;
    private double result;
    private LocalDateTime timestamp;

    // Getters and Setters
    // ...
}
