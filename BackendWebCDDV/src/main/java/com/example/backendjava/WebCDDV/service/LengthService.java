package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LengthService {
    private final Map<String, Double> conversionRates;

    public LengthService() {
        conversionRates = new HashMap<>();
        conversionRates.put("km", 1.0e3);   // km to m
        conversionRates.put("m", 1.0);      // m to m
        conversionRates.put("dm", 0.1);     // dm to m
        conversionRates.put("cm", 0.01);    // cm to m
        conversionRates.put("mm", 0.001);   // mm to m
        conversionRates.put("µm", 1.0e-6);  // µm to m
        conversionRates.put("nm", 1.0e-9);  // nm to m
        conversionRates.put("Å", 1.0e-10);  // Å to m
    }

    public double convertLength(double amount, String unitFrom, String unitTo) {
        // Kiểm tra xem các đơn vị có hợp lệ không
        if (!conversionRates.containsKey(unitFrom) || !conversionRates.containsKey(unitTo)) {
            throw new IllegalArgumentException("Invalid unit: " + unitFrom + " or " + unitTo);
        }

        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);

        // Chuyển đổi chiều dài
        return (amount * fromRate) / toRate;
    }
}
