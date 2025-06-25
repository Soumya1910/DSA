package com.dsa.Thread.Lock.MonitorLock;

public class MainClass {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        Thread thread1 = new Thread(() -> resource1.produce(), "Thread 1");
        SharedResource resource2 = new SharedResource();
        Thread thread2 = new Thread(() -> resource2.consume(), "Thread 2");
        thread1.start();
        thread2.start();
    }
}
