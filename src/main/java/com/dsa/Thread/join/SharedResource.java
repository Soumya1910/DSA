package com.dsa.Thread.join;

public class SharedResource {

    public synchronized void waitingForSomeTimes() {
        try {
            System.out.println("Before Sleep time : " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("After sleep time : " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
