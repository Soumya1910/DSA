package com.dsa.design.pattern.behaviour.strategy.two;

public class NormalCar extends Vehicle{
    public NormalCar(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
