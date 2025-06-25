package com.dsa.design.pattern.behaviour.chainOfResponsibility.two;

public class ClientCode {
    public static void main(String[] args) {
        LogProcessor infoLog = new InfoLogProcessor();
        LogProcessor debugLog = new DebugLogProcessor();
        LogProcessor errorLog = new ErrorLogProcessor();

        infoLog.setNextLogProcessor(debugLog);
        debugLog.setNextLogProcessor(errorLog);

        infoLog.processLog("DEBUG");
        System.out.println("-------");
        infoLog.processLog("ERROR");
    }
}
