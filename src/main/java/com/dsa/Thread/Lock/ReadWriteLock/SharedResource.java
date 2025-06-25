package com.dsa.Thread.Lock.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class SharedResource {
    public void producer(ReadWriteLock lock) {
        lock.readLock().lock();
        System.out.println("Read lock acquired by " + Thread.currentThread().getName() + " for producing at: " + getCurrentTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Read lock released by " + Thread.currentThread().getName() + " for producing at: " + getCurrentTime() + " with success!  ");
            lock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock lock) {
        lock.writeLock().lock();
        System.out.println("Write lock acquired by " + Thread.currentThread().getName() + " for consuming at: " + getCurrentTime());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Write lock released by " + Thread.currentThread().getName() + " for consuming at: " + getCurrentTime() + " with success!  ");
            lock.writeLock().unlock();
        }
    }
}
