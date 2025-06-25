package com.dsa.design.pattern.behaviour.strategy.one;

public class DebitCardPaymentStrategy extends PaymentStrategy{

    public DebitCardPaymentStrategy(PaymentAPIGateway paymentAPIGateway) {
        super(paymentAPIGateway);
    }
}
