package com.dsa.design.pattern.behaviour.chainOfResponsibility.one;

public class ClientCode {
    public static void main(String[] args) {
        SupportHandler level1Handler = new Level1Handler();
        SupportHandler level2Handler = new Level2Handler();
        SupportHandler level3Handler = new Level3Handler();

        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);

        level1Handler.handleRequest("BASIC");
        System.out.println("-----------");
        level1Handler.handleRequest("URGENT");
    }
}
