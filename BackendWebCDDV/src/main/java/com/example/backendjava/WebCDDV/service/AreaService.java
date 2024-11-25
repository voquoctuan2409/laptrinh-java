package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AreaService {
    private final Map<String, Double> conversionRates;

    public AreaService() {
        conversionRates = new HashMap<>();
        conversionRates.put("km²", 1.0e6); // km² to m²
        conversionRates.put("m²", 1.0);    // m² là đơn vị cơ bản
        conversionRates.put("ha", 1.0e4); // hecta to m²
        conversionRates.put("a", 100.0);  // are to m²
        conversionRates.put("cm²", 0.0001);
        conversionRates.put("mm²", 0.000001);
    }

    public double convertArea(double amount, String unitFrom, String unitTo) {
        if (!conversionRates.containsKey(unitFrom) || !conversionRates.containsKey(unitTo)) {
            throw new IllegalArgumentException("Invalid area units provided");
        }

        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);

        return (amount * fromRate) / toRate;
    }
}
