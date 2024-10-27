package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    public double convert(double value, String fromUnit, String toUnit) {
        // Logic chuyển đổi nhiệt độ
        if (fromUnit.equals("Celsius")) {
            if (toUnit.equals("Fahrenheit")) return value * 9/5 + 32;
            if (toUnit.equals("Kelvin")) return value + 273.15;
        }
        // Thêm logic cho các đơn vị khác
        throw new IllegalArgumentException("Đơn vị không hợp lệ");
    }
}

