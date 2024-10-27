package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

@Service
public class WeightService {

    public double convert(double value, String fromUnit, String toUnit) {
        // Logic chuyển đổi trọng lượng
        if (fromUnit.equals("kg")) {
            if (toUnit.equals("g")) return value * 1000;
            if (toUnit.equals("pound")) return value * 2.20462;
            if (toUnit.equals("ounce")) return value * 35.274;
        }
        // Thêm logic cho các đơn vị khác
        throw new IllegalArgumentException("Đơn vị không hợp lệ");
    }
}
