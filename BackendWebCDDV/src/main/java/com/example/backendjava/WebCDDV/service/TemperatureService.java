package com.example.backendjava.WebCDDV.service;

import org.springframework.stereotype.Service;


@Service
public class TemperatureService {
    public double convertTemperature(double amount, String unitFrom, String unitTo, int decimals) {
        double result = 0.0;

        // Kiểm tra nếu các đơn vị hợp lệ
        if (!isValidUnit(unitFrom) || !isValidUnit(unitTo)) {
            throw new IllegalArgumentException("Invalid temperature unit.");
        }

        // Nếu đơn vị nguồn và đích giống nhau, trả về giá trị gốc
        if (unitFrom.equals(unitTo)) {
            return amount;
        }

        // Chuyển từ Celsius
        switch (unitFrom) {
            case "C":
                result = convertFromCelsius(amount, unitTo);
                break;
            case "K":
                result = convertFromKelvin(amount, unitTo);
                break;
            case "F":
                result = convertFromFahrenheit(amount, unitTo);
                break;
            case "R":
                result = convertFromReaumur(amount, unitTo);
                break;
            case "rankine":
                result = convertFromRankine(amount, unitTo);
                break;
        }

        // Trả về kết quả với số chữ số thập phân mong muốn
        return roundToDecimals(result, decimals);
    }

    private boolean isValidUnit(String unit) {
        return unit.equals("C") || unit.equals("K") || unit.equals("F") ||
                unit.equals("R") || unit.equals("rankine");
    }

    private double convertFromCelsius(double amount, String unitTo) {
        switch (unitTo) {
            case "K": return amount + 273.15;
            case "F": return (amount * 9/5) + 32;
            case "R": return amount * 4/5;
            case "rankine": return (amount + 273.15) * 9/5;
            default: return amount;
        }
    }

    private double convertFromKelvin(double amount, String unitTo) {
        switch (unitTo) {
            case "C": return amount - 273.15;
            case "F": return (amount - 273.15) * 9/5 + 32;
            case "R": return (amount - 273.15) * 4/5;
            case "rankine": return amount * 9/5;
            default: return amount;
        }
    }

    private double convertFromFahrenheit(double amount, String unitTo) {
        switch (unitTo) {
            case "C": return (amount - 32) * 5/9;
            case "K": return (amount - 32) * 5/9 + 273.15;
            case "R": return (amount - 32) * 4/9;
            case "rankine": return amount + 459.67;
            default: return amount;
        }
    }

    private double convertFromReaumur(double amount, String unitTo) {
        switch (unitTo) {
            case "C": return amount * 5/4;
            case "K": return amount * 5/4 + 273.15;
            case "F": return amount * 9/4 + 32;
            case "rankine": return (amount * 5/4 + 273.15) * 9/5;
            default: return amount;
        }
    }

    private double convertFromRankine(double amount, String unitTo) {
        switch (unitTo) {
            case "C": return (amount - 491.67) * 5/9;
            case "K": return amount * 5/9;
            case "F": return amount - 459.67;
            case "R": return (amount - 491.67) * 4/9;
            default: return amount;
        }
    }

    private double roundToDecimals(double value, int decimals) {
        return Math.round(value * Math.pow(10, decimals)) / Math.pow(10, decimals);
    }
}
