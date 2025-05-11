package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.CustomerPolicyRequest;
import com.example.service.PremiumCalculatorService;

class PremiumCalculatorServiceTest {

    private PremiumCalculatorService premiumCalculatorService;

    @BeforeEach
    void setUp() {
        premiumCalculatorService = new PremiumCalculatorService();
    }

    @Test
    void testCalculatePremiumYoungNonSmokerBasic() {
        CustomerPolicyRequest request = new CustomerPolicyRequest();
        request.setCustomerName("John Doe");
        request.setAge(30);
        request.setPlanType("BASIC");
        request.setSmoker(false);

        double premium = premiumCalculatorService.calculatePremium(request);
        assertEquals(5000.0, premium);
    }

    @Test
    void testCalculatePremiumSmokerAged55Premium() {
        CustomerPolicyRequest request = new CustomerPolicyRequest();
        request.setCustomerName("Jane Doe");
        request.setAge(55);
        request.setPlanType("PREMIUM");
        request.setSmoker(true);

        double premium = premiumCalculatorService.calculatePremium(request);
        assertEquals(15600, ((int) premium)); // 12000 + 20% + 10%
    }

    @Test
    void testCalculatePremiumInvalidPlanType() {
        CustomerPolicyRequest request = new CustomerPolicyRequest();
        request.setCustomerName("Invalid User");
        request.setAge(40);
        request.setPlanType("INVALID_PLAN");
        request.setSmoker(false);

        assertThrows(IllegalArgumentException.class, () -> {
            premiumCalculatorService.calculatePremium(request);
        });
    }
}