package com.dsa.design.pattern.behaviour.strategy.two;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving at normal speed.");
    }
}
