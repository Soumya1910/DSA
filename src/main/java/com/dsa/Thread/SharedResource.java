package com.dsa.Thread;

public class SharedResource {
    boolean isItemAvailable = false;

    // Synchronized method to put the Monitor lock on Object
    public synchronized void addItem() {
        System.out.println("addItem method is called by " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isItemAvailable  = true;
        System.out.println("Item added successfully");
        notifyAll(); // Wakes up a waiting thread if any
    }

    public synchronized void consumeItem() {
        System.out.println("consumeItem method is called by " + Thread.currentThread().getName());
        // Waits until isItemAvailable becomes true by addItem method or until notified by notifyAll() method

        while (!isItemAvailable) {
            try {
                System.out.println("Consumer Thread is waiting for item availability");
                wait(); // Puts the current thread to sleep until notified, monitor lock is acquired by another thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isItemAvailable = false;
        System.out.println("Consumed an item");
    }
}
