package com.dsa.Thread.Lock.SemaphoreLock;

public class MainClass {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        Thread thread1 = new Thread(() -> resource1.produce(), "Thread 1");
        Thread thread2 = new Thread(() -> resource1.produce(), "Thread 2");
        Thread thread3 = new Thread(() -> resource1.produce(), "Thread 3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
