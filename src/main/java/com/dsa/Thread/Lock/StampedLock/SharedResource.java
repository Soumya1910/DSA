package com.dsa.Thread.Lock.StampedLock;

import java.util.concurrent.locks.StampedLock;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class SharedResource {

    public void producer(StampedLock lock) {
        long stamp = lock.readLock();
        System.out.println("Stamped lock acquired by " + Thread.currentThread().getName() + " for producing at : " + getCurrentTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Stamped lock released by " + Thread.currentThread().getName() + " for producing at : " + getCurrentTime() + " with success!  ");
            lock.unlockRead(stamp);
        }
    }

    public void consumer(StampedLock lock) {
        long stamp = lock.readLock();
        System.out.println("Stamped lock acquired by " + Thread.currentThread().getName() + " for consuming at : " + getCurrentTime());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Stamped lock released by " + Thread.currentThread().getName() + " for consuming at : " + getCurrentTime() + " with success!  ");
            lock.unlockRead(stamp);
        }
    }
}
