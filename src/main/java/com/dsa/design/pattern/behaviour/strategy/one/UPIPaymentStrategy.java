package com.dsa.design.pattern.behaviour.strategy.one;

public class UPIPaymentStrategy extends PaymentStrategy{
    public UPIPaymentStrategy(PaymentAPIGateway paymentAPIGateway) {
        super(paymentAPIGateway);
    }
}
