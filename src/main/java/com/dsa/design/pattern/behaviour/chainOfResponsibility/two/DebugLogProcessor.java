package com.dsa.design.pattern.behaviour.chainOfResponsibility.two;

public class DebugLogProcessor implements LogProcessor {
    private LogProcessor logProcessor;
    @Override
    public void setNextLogProcessor(LogProcessor logProcessor) {
        this.logProcessor = logProcessor;
    }

    @Override
    public void processLog(String logType) {
        if("DEBUG".equalsIgnoreCase(logType)) {
            System.out.println("Received DEBUG log.. Processing it..");
        } else {
            if(logProcessor!=null) {
                logProcessor.processLog(logType);
                System.out.println("Forwarded DEBUG log to next processor");
            }
        }
    }
}
