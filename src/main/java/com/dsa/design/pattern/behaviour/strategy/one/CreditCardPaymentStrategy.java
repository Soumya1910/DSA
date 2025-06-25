package com.dsa.design.pattern.behaviour.strategy.one;

public class CreditCardPaymentStrategy extends PaymentStrategy{
    public CreditCardPaymentStrategy(PaymentAPIGateway paymentAPIGateway) {
        super(paymentAPIGateway);
    }
}
