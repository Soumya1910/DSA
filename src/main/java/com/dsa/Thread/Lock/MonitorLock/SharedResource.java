package com.dsa.Thread.Lock.MonitorLock;

public class SharedResource {

    public synchronized void produce() {
        System.out.println("Lock acquired by " + Thread.currentThread().getName() + " for producing");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock released by " + Thread.currentThread().getName() + " for producing");
    }

    public synchronized void consume() {
        System.out.println("Lock acquired by " + Thread.currentThread().getName() + " for consuming");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock released by " + Thread.currentThread().getName() + " for consuming");
    }
}
