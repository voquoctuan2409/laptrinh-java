package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LengthService {
    private final Map<String, Double> conversionRates;

    public LengthService() {
        conversionRates = new HashMap<>();
        conversionRates.put("m", 1.0); // m là đơn vị cơ bản
        conversionRates.put("cm", 0.01);
        conversionRates.put("mm", 0.001);
        conversionRates.put("km", 1000.0);
        // Thêm các đơn vị khác nếu cần
    }

    public double convertLength(double amount, String unitFrom, String unitTo) {
        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);
        return (amount * fromRate) / toRate;
    }
}
