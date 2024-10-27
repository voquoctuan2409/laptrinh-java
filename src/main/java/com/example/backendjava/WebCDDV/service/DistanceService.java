package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    public double convert(double value, String fromUnit, String toUnit) {
        // Logic chuyển đổi khoảng cách
        if (fromUnit.equals("km")) {
            if (toUnit.equals("m")) return value * 1000;
            if (toUnit.equals("cm")) return value * 100000;
            if (toUnit.equals("inch")) return value * 39370.1;
        }
        // Thêm logic cho các đơn vị khác
        throw new IllegalArgumentException("Đơn vị không hợp lệ");
    }
}

