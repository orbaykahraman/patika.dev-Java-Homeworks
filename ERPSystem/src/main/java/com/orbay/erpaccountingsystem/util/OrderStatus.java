package com.orbay.erpaccountingsystem.util;

public enum OrderStatus {
    DEFAULT("DEFAULT"),
    APPROVED("APPROVED"),
    DELIVERING("DELIVERING"),
    CANCELLED("CANCELLED");

    private String orderValue;

     OrderStatus(String orderValue) {
        this.orderValue = orderValue;
    }

    public String getOrderValue() {
         return orderValue;
    }
}
