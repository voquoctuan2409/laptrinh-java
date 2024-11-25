package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class SpeedService {
    private final Map<String, Double> conversionRates;

    public SpeedService() {
        conversionRates = new HashMap<>();
        conversionRates.put("mps", 1.0);         // Mét/giây (m/s) là đơn vị cơ bản
        conversionRates.put("kmph", 0.277778);   // 1 km/h = 0.277778 m/s
        conversionRates.put("mph", 0.44704);     // 1 mph = 0.44704 m/s
        conversionRates.put("fps", 0.3048);      // 1 ft/s = 0.3048 m/s
        conversionRates.put("knot", 0.514444);   // 1 knot = 0.514444 m/s
    }

    public double convertSpeed(double amount, String unitFrom, String unitTo) {
        if (!conversionRates.containsKey(unitFrom) || !conversionRates.containsKey(unitTo)) {
            throw new IllegalArgumentException("Invalid speed units provided");
        }

        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);

        return (amount * fromRate) / toRate;
    }
}
