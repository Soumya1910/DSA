package com.dsa.design.pattern.behaviour.strategy.two;

public class SportsCar extends Vehicle{
    public SportsCar(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
