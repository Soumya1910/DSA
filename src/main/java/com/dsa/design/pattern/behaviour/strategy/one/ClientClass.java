package com.dsa.design.pattern.behaviour.strategy.one;

public class ClientClass {
    public static void main(String[] args) {
        PaymentStrategy debitCardPaymentStrategy = new DebitCardPaymentStrategy(new BillDeskAPIGateway());
        debitCardPaymentStrategy.pay();

        PaymentStrategy debitCardPaymentPayPalStrategy = new DebitCardPaymentStrategy(new PayPalAPIGateway());
        debitCardPaymentPayPalStrategy.pay();

    }
}
