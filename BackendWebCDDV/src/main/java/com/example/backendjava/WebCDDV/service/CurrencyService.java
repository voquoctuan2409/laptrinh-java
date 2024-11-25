package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {
    private final Map<String, Double> conversionRates;

    public CurrencyService() {
        conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0); // USD là đơn vị cơ bản
        conversionRates.put("EUR", 1.0 / 0.93);
        conversionRates.put("JPY", 1.0 / 133.0);
        conversionRates.put("GBP", 1.0 / 0.8);
        conversionRates.put("VND", 1.0 / 24000.0);
        conversionRates.put("AUD", 1.0 / 1.35);
    }

    public double convertCurrency(double amount, String unitFrom, String unitTo) {
        if (!conversionRates.containsKey(unitFrom) || !conversionRates.containsKey(unitTo)) {
            throw new IllegalArgumentException("Invalid currency units provided");
        }

        double fromRate = conversionRates.get(unitFrom);
        double toRate = conversionRates.get(unitTo);

        return (amount * fromRate) / toRate;
    }


}
