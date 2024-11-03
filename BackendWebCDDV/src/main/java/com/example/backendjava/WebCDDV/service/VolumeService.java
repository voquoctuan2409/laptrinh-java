package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class VolumeService {
    private final Map<String, Double> conversionRates;

    public VolumeService() {
        conversionRates = new HashMap<>();
        conversionRates.put("l", 1.0); // l là đơn vị cơ bản
        conversionRates.put("ml", 0.001);
        conversionRates.put("cm³", 0.001);
        conversionRates.put("m³", 1000.0);
        conversionRates.put("km³", 1.0e9);
        // Thêm các đơn vị khác nếu cần
    }

    public double convertVolume(double amount, String unitFrom, String unitTo) {
        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);
        return (amount * fromRate) / toRate;
    }
}