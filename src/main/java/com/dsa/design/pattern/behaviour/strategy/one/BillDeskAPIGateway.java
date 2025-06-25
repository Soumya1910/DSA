package com.dsa.design.pattern.behaviour.strategy.one;

public class BillDeskAPIGateway implements PaymentAPIGateway {
    @Override
    public void pay() {
        System.out.println("Paying using BillDesk");
    }
}
