package com.dsa.design.pattern.behaviour.strategy.one;

public class PayPalAPIGateway implements PaymentAPIGateway {
    @Override
    public void pay() {
        System.out.println("Paying using PayPal");
    }
}
