package com.dsa.design.pattern.behaviour.strategy.two;

public class ClientClass {
    public static void main(String[] args) {
        Vehicle mercedes = new LuxuaryCar(new LuxuryDriveStrategy());
        mercedes.drive();

        Vehicle normalCar = new NormalCar(new NormalDriveStrategy());
        normalCar.drive();

        Vehicle audi = new SportsCar(new LuxuryDriveStrategy());
        audi.drive();
    }
}
