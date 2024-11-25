package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.model.ConversionRequest;
import com.example.backendjava.WebCDDV.model.ConversionResponse;
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

    @PostMapping("/volume")
    public ConversionResponse convertVolume(@RequestBody ConversionRequest request) {
        double result = volumeService.convertVolume(request.getAmount(), request.getUnitFrom(), request.getUnitTo());
        return new ConversionResponse(result);
    }
}
