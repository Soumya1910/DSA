package com.dsa.design.pattern.behaviour.chainOfResponsibility.one;

public interface SupportHandler {
    void setNextHandler(SupportHandler supportHandler);
    void handleRequest(String issueType);
}
