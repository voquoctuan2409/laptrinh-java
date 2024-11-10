package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.service.TemperatureService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class TemperatureController {

    private final TemperatureService temperatureService;

    // Constructor Injection của TemperatureService
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    // API để chuyển đổi nhiệt độ
    @GetMapping("/temperature")
    public double convertTemperature(@RequestParam double amount,
                                     @RequestParam String unitFrom,
                                     @RequestParam String unitTo,
                                     @RequestParam int decimals) {
        return temperatureService.convertTemperature(amount, unitFrom, unitTo, decimals);
    }
}
