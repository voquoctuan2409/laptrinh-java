package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {
    public double convertTemperature(double amount, String unitFrom, String unitTo) {
        if (!unitFrom.equals("C")) {
            if (unitFrom.equals("F")) {
                if (unitTo.equals("C")) {
                    return (amount - 32) * 5/9;
                } else if (unitTo.equals("K")) {
                    return (amount - 32) * 5/9 + 273.15;
                }
            } else if (unitFrom.equals("K")) {
                if (unitTo.equals("C")) {
                    return amount - 273.15;
                } else if (unitTo.equals("F")) {
                    return (amount - 273.15) * 9/5 + 32;
                }
            }
        } else {
            if (unitTo.equals("F")) {
                return (amount * 9/5) + 32;
            } else if (unitTo.equals("K")) {
                return amount + 273.15;
            }
        }
        return amount; // Nếu không có chuyển đổi, trả lại giá trị gốc
    }
}
