package com.dsa.design.pattern.behaviour.chainOfResponsibility.one;

public class Level3Handler implements SupportHandler {
    private SupportHandler supportHandler;
    @Override
    public void setNextHandler(SupportHandler supportHandler) {
        this.supportHandler = supportHandler;
    }

    @Override
    public void handleRequest(String issueType) {
    if ("URGENT".equalsIgnoreCase(issueType)) {
            System.out.println("Level 3 Support team should handle this request");
        } else {
            System.out.println("No one in the chain can handle this request");
        }
    }
}
