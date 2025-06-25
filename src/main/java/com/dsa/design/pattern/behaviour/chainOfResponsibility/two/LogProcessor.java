package com.dsa.design.pattern.behaviour.chainOfResponsibility.two;

public interface LogProcessor {
    void setNextLogProcessor(LogProcessor logProcessor);
    void processLog(String logType);
}
