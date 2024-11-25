package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.model.ConversionRequest;
import com.example.backendjava.WebCDDV.model.ConversionResponse;
import com.example.backendjava.WebCDDV.service.LengthService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class LengthController {

    private final LengthService lengthService;

    public LengthController(LengthService lengthService) {
        this.lengthService = lengthService;
    }

    @PostMapping("/length")
    public ConversionResponse convertLength(@RequestBody ConversionRequest request) {
        double result = lengthService.convertLength(request.getAmount(), request.getUnitFrom(), request.getUnitTo());
        return new ConversionResponse(result);
    }
}
