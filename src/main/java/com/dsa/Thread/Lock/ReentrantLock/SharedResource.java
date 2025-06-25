package com.dsa.Thread.Lock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class SharedResource {

    public void produce(ReentrantLock lock) {
        lock.lock();
        System.out.println("Lock acquired by " + Thread.currentThread().getName() + " for producing at: "+ getCurrentTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Lock released by " + Thread.currentThread().getName() + " for producing at: "+ getCurrentTime() + " with success!  ");
            lock.unlock();
        }
    }
}
