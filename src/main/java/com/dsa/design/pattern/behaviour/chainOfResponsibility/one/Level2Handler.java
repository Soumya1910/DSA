package com.dsa.design.pattern.behaviour.chainOfResponsibility.one;

public class Level2Handler implements SupportHandler {
    private SupportHandler supportHandler;

    @Override
    public void setNextHandler(SupportHandler supportHandler) {
        this.supportHandler = supportHandler;
    }

    @Override
    public void handleRequest(String issueType) {
        if ("COMPLEX".equalsIgnoreCase(issueType)) {
            System.out.println("Level 2 Support team should handle this request");
        } else {
            if (supportHandler != null) {
                supportHandler.handleRequest(issueType);
                System.out.println("Level 2 has forwarded to Level 3");
            }
        }
    }
}
