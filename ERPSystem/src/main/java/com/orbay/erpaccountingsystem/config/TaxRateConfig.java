package com.orbay.erpaccountingsystem.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class TaxRateConfig {

    @Value("${tax.rate}")
    private double taxRate;

    public double calculatePriceWithTaxRate(double price) {
        return price + (price * taxRate);
    }
}
