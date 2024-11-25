package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.model.ConversionRequest;
import com.example.backendjava.WebCDDV.model.ConversionResponse;
import com.example.backendjava.WebCDDV.service.MassService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class MassController {

    private final MassService massService;

    public MassController(MassService massService) {
        this.massService = massService;
    }

    @PostMapping("/mass")
    public ConversionResponse convertMass(@RequestBody ConversionRequest request) {
        double result = massService.convertMass(request.getAmount(), request.getUnitFrom(), request.getUnitTo());
        return new ConversionResponse(result);
    }
}
