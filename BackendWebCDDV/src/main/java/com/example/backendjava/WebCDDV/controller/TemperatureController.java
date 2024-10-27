package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.service.TemperatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {
    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/convert")
    public ResponseEntity<Double> convertTemperature(
            @RequestParam double value,
            @RequestParam String fromUnit,
            @RequestParam String toUnit) {
        double result = temperatureService.convert(value, fromUnit, toUnit);
        return ResponseEntity.ok(result);
    }
}

