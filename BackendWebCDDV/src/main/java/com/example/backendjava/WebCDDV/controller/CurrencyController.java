package com.example.backendjava.WebCDDV.controller;

import com.example.backendjava.WebCDDV.model.ConversionRequest;
import com.example.backendjava.WebCDDV.model.ConversionResponse;
import com.example.backendjava.WebCDDV.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/conversion")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("/currency")
    public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
        double result = currencyService.convertCurrency(request.getAmount(), request.getUnitFrom(), request.getUnitTo());
        return new ConversionResponse(result);
    }
}
