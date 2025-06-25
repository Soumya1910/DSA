package com.dsa.Thread.Lock.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Thread thread1 = new Thread(() -> resource1.producer(lock), "Thread 1");
        Thread thread2 = new Thread(() -> resource2.consumer(lock), "Thread 2");
        Thread thread3 = new Thread(() -> resource1.producer(lock), "Thread 3");
        thread2.start();
        thread1.start();
        thread3.start();
    }
}
