package com.dsa.design.pattern.behaviour.strategy.one;

public abstract class PaymentStrategy {
    private PaymentAPIGateway paymentAPIGateway;
    public PaymentStrategy(PaymentAPIGateway paymentAPIGateway) {
        this.paymentAPIGateway = paymentAPIGateway;
    }

    public void pay() {
        paymentAPIGateway.pay();
    }
}
