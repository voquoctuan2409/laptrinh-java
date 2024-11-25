package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MassService {
    private final Map<String, Double> conversionRates;

    public MassService() {
        conversionRates = new HashMap<>();
        conversionRates.put("kg", 1.0);          // kg to kg
        conversionRates.put("g", 0.001);         // g to kg
        conversionRates.put("mg", 1.0e-6);       // mg to kg
        conversionRates.put("t", 1000.0);        // t (ton) to kg
        conversionRates.put("kN", 0.009806652);  // kN (kilonewton) to kg
        conversionRates.put("hg", 10.0);         // hg (hectogram) to kg
        conversionRates.put("dag", 100.0);       // dag (decagram) to kg
        conversionRates.put("karat", 5000.0);    // karat to kg
        conversionRates.put("centigram", 100000.0);  // centigram to kg
        conversionRates.put("µg", 1.0e9);        // microgram to kg
        conversionRates.put("ng", 1.0e12);       // nanogram to kg
        conversionRates.put("u", 6.022045e26);   // Atomic mass unit (u) to kg
    }

    public double convertMass(double amount, String unitFrom, String unitTo) {
        // Kiểm tra xem các đơn vị có hợp lệ không
        if (!conversionRates.containsKey(unitFrom) || !conversionRates.containsKey(unitTo)) {
            throw new IllegalArgumentException("Invalid unit: " + unitFrom + " or " + unitTo);
        }

        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);

        return (amount * fromRate) / toRate;
    }


}
