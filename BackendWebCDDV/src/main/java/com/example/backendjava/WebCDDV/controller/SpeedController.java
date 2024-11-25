package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.model.ConversionRequest;
import com.example.backendjava.WebCDDV.model.ConversionResponse;
import com.example.backendjava.WebCDDV.service.SpeedService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class SpeedController {

    private final SpeedService speedService;

    public SpeedController(SpeedService speedService) {
        this.speedService = speedService;
    }

    @PostMapping("/speed")
    public ConversionResponse convertSpeed(@RequestBody ConversionRequest request) {
        double result = speedService.convertSpeed(request.getAmount(), request.getUnitFrom(), request.getUnitTo());
        return new ConversionResponse(result);
    }
}
