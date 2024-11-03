package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.service.MassService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion")
public class MassController {

    private final MassService massService;

    public MassController(MassService massService) {
        this.massService = massService;
    }

    @GetMapping("/mass")
    public double convertMass(@RequestParam double amount, @RequestParam String unitFrom, @RequestParam String unitTo) {
        return massService.convertMass(amount, unitFrom, unitTo);
    }
}
