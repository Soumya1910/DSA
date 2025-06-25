package com.dsa.Thread.Lock.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class MainClass {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        StampedLock lock = new StampedLock();
        Thread thread1 = new Thread(() -> resource1.producer(lock), "Thread 1");
        Thread thread2 = new Thread(() -> resource1.consumer(lock), "Thread 2");

        SharedResource resource2 = new SharedResource();
        Thread thread3 = new Thread(() -> resource2.producer(lock), "Thread 3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
