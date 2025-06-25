package com.dsa.design.pattern.behaviour.chainOfResponsibility.one;

public class Level1Handler implements SupportHandler {
    private SupportHandler supportHandler;
    @Override
    public void setNextHandler(SupportHandler supportHandler) {
        this.supportHandler = supportHandler;
    }

    @Override
    public void handleRequest(String issueType) {
        if("BASIC".equalsIgnoreCase(issueType)) {
            System.out.println("Level 1 Support Team should handle this request");
        } else {
            if(supportHandler != null) {
                supportHandler.handleRequest(issueType);
                System.out.println("Level 1 has forwarded to Level 2");
            }
        }
    }
}
