package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.service.DistanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distance")
public class DistanceController {
    private final DistanceService distanceService;

    public DistanceController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/convert")
    public ResponseEntity<Double> convertDistance(
            @RequestParam double value,
            @RequestParam String fromUnit,
            @RequestParam String toUnit) {
        double result = distanceService.convert(value, fromUnit, toUnit);
        return ResponseEntity.ok(result);
    }
}
