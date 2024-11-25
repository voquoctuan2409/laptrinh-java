package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class VolumeService {
    private final Map<String, Double> conversionRates;

    public VolumeService() {
        conversionRates = new HashMap<>();
        conversionRates.put("km³", 1.0e12);
        conversionRates.put("m³", 1.0e3);
        conversionRates.put("hl", 1.0e2);
        conversionRates.put("decaliter", 10.0);
        conversionRates.put("dm³", 1.0); // dm³ là đơn vị cơ bản
        conversionRates.put("l", 1.0);
        conversionRates.put("dl", 0.1);
        conversionRates.put("cl", 0.01);
        conversionRates.put("cm³", 0.001);
        conversionRates.put("ml", 0.001);
        conversionRates.put("mm³", 1.0e-6);
        conversionRates.put("µl", 1.0e-6);
    }

    public double convertVolume(double amount, String unitFrom, String unitTo) {
        // Kiểm tra xem đơn vị có tồn tại trong danh sách không
        if (!conversionRates.containsKey(unitFrom) || !conversionRates.containsKey(unitTo)) {
            throw new IllegalArgumentException("Invalid units provided");
        }

        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);

        return (amount * fromRate) / toRate;
    }

}
