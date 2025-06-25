package com.dsa.design.pattern.behaviour.chainOfResponsibility.two;

public class ErrorLogProcessor implements LogProcessor {
    private LogProcessor logProcessor;

    @Override
    public void setNextLogProcessor(LogProcessor logProcessor) {
        this.logProcessor = logProcessor;
    }

    @Override
    public void processLog(String logType) {
        if("ERROR".equalsIgnoreCase(logType)) {
            System.out.println("Received ERROR log.. Processing it..");
        } else {
            System.out.println("Unknown type of logType, can't be processed");
        }
    }
}
