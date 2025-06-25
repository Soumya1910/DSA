package com.dsa.design.pattern.behaviour.strategy.two;

public class LuxuaryCar extends Vehicle{
    public LuxuaryCar(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
