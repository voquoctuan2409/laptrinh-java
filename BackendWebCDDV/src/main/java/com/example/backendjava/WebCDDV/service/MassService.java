package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MassService {
    private final Map<String, Double> conversionRates;

    public MassService() {
        conversionRates = new HashMap<>();
        conversionRates.put("kg", 1.0); // kg là đơn vị cơ bản
        conversionRates.put("g", 0.001);
        conversionRates.put("mg", 0.000001);
        conversionRates.put("t", 1000.0);
        // Thêm các đơn vị khác nếu cần
    }

    public double convertMass(double amount, String unitFrom, String unitTo) {
        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);
        return (amount * fromRate) / toRate;
    }
}
