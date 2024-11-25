package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.model.ConversionRequest;
import com.example.backendjava.WebCDDV.model.ConversionResponse;
import com.example.backendjava.WebCDDV.service.TemperatureService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class TemperatureController {

    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @PostMapping("/temperature")
    public ConversionResponse convertTemperature(@RequestBody ConversionRequest request) {
        double result = temperatureService.convertTemperature(request.getAmount(),
                request.getUnitFrom(),
                request.getUnitTo(),
                request.getDecimals());
        return new ConversionResponse(result);
    }
}
