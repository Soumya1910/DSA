package com.dsa.Thread.Lock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> resource1.produce(lock), "Thread 1");
        Thread thread2 = new Thread(() -> resource2.produce(lock), "Thread 2");
        thread1.start();
        thread2.start();
    }
}
