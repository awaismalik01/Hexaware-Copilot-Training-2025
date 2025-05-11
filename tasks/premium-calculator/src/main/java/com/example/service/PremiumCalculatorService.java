// This file defines the PremiumCalculatorService class, which includes the method calculatePremium(CustomerPolicyRequest request) that calculates the insurance premium based on the provided request.

package com.example.service;

import com.example.model.CustomerPolicyRequest;

public class PremiumCalculatorService {

    public double calculatePremium(CustomerPolicyRequest request) {
        double basePremium;

        switch (request.getPlanType().toUpperCase()) {
            case "BASIC":
                basePremium = 5000;
                break;
            case "STANDARD":
                basePremium = 8000;
                break;
            case "PREMIUM":
                basePremium = 12000;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type: " + request.getPlanType());
        }

        if (request.isSmoker() && request.getAge() > 50) {
            basePremium *= 1.3; // Add 30% for smokers over 50
        }
        else if (request.isSmoker()) {
            basePremium *= 1.2; // Add 20% for smokers
        }
        else if (request.getAge() > 50) {
            basePremium *= 1.1; // Add 10% surcharge for age > 50
        }

        return basePremium;
    }
}