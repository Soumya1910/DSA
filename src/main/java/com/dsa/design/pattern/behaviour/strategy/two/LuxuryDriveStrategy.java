package com.dsa.design.pattern.behaviour.strategy.two;

public class LuxuryDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving at luxury speed.");
    }
}
