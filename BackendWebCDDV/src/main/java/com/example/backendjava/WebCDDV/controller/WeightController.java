package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.service.WeightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weight")
public class WeightController {
    private final WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping("/convert")
    public ResponseEntity<Double> convertWeight(
            @RequestParam double value,
            @RequestParam String fromUnit,
            @RequestParam String toUnit) {
        double result = weightService.convert(value, fromUnit, toUnit);
        return ResponseEntity.ok(result);
    }
}
