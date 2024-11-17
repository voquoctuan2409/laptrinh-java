package com.example.backendjava.WebCDDV.controller;

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

    @GetMapping("/length")
    public double convertLength(@RequestParam double amount, @RequestParam String unitFrom, @RequestParam String unitTo) {
        return lengthService.convertLength(amount, unitFrom, unitTo);
    }
}
