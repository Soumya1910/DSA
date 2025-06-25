package com.dsa.Thread;

public class MonitorLockExample {

    private int counter = 0;

    // Synchronized method: Monitor lock is associated with the instance of the class
    public synchronized void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
    }

    // Synchronized block: Monitor lock is associated with the object passed in the synchronized block
    public void decrement() {
        synchronized (this) { // Monitor lock on the current instance
            counter--;
            System.out.println(Thread.currentThread().getName() + " decremented counter to: " + counter);
        }
    }

    public static void main(String[] args) {
        MonitorLockExample example = new MonitorLockExample();

        // Create multiple threads to demonstrate monitor lock
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                example.decrement();
            }
        };

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();

    }
}