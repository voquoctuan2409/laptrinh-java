package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.service.TemperatureService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion")
public class TemperatureController {

    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/temperature")
    public double convertTemperature(@RequestParam double amount, @RequestParam String unitFrom, @RequestParam String unitTo) {
        return temperatureService.convertTemperature(amount, unitFrom, unitTo);
    }
}
