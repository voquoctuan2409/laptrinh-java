package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.service.VolumeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class VolumeController {

    private final VolumeService volumeService;

    public VolumeController(VolumeService volumeService) {
        this.volumeService = volumeService;
    }

    @GetMapping("/volume")
    public double convertVolume(@RequestParam double amount, @RequestParam String unitFrom, @RequestParam String unitTo) {
        return volumeService.convertVolume(amount, unitFrom, unitTo);
    }
}
