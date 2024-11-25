package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.model.ConversionRequest;
import com.example.backendjava.WebCDDV.model.ConversionResponse;
import com.example.backendjava.WebCDDV.service.AreaService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/area")
    public ConversionResponse convertArea(@RequestBody ConversionRequest request) {
        double result = areaService.convertArea(request.getAmount(), request.getUnitFrom(), request.getUnitTo());
        return new ConversionResponse(result);
    }
}
