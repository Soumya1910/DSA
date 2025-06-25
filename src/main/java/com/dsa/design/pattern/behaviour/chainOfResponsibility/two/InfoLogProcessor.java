package com.dsa.design.pattern.behaviour.chainOfResponsibility.two;

public class InfoLogProcessor implements LogProcessor {
    private LogProcessor logProcessor;
    @Override
    public void setNextLogProcessor(LogProcessor logProcessor) {
        this.logProcessor = logProcessor;
    }

    @Override
    public void processLog(String logType) {
        if("INFO".equalsIgnoreCase(logType)) {
            System.out.println("Received INFO log.. Processing it..");
        } else {
            if(logProcessor!= null) {
                logProcessor.processLog(logType);
                System.out.println("Forwarded INFO log to next processor");
            }
        }
    }
}
