package com.dsa.Thread.Lock.SemaphoreLock;

import java.util.concurrent.Semaphore;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class SharedResource {
    Semaphore lock = new Semaphore(2); // two threads can access the resource simultaneously
    public void produce() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by " + Thread.currentThread().getName() + " for producing at: " + getCurrentTime());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.release();
            System.out.println("Lock released by " + Thread.currentThread().getName() + " for producing at: " + getCurrentTime() + " with success!");
        }
    }
}
