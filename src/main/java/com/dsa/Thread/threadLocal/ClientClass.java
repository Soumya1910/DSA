package com.dsa.Thread.threadLocal;

public class ClientClass {
    /**
     * The main method demonstrates the usage of ThreadLocal to maintain thread-specific data.
     * It initializes a ThreadLocal variable, sets a value in the main thread, and starts a new thread
     * to showcase how ThreadLocal provides isolated values for each thread.
     *
     * @param args Command-line arguments passed to the program. Not used in this implementation.
     */
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        System.out.println("Before changing value: " + threadLocal.get());
        threadLocal.set(Thread.currentThread().getName());
        Thread thread1 = new Thread(() -> {
            System.out.println("Inside thread 1: " + threadLocal.get());
            threadLocal.set(Thread.currentThread().getName() + "-Modified");
            System.out.println("Inside thread 1 after modification: " + threadLocal.get());
        });
        thread1.start();
        System.out.println("After changing value from main: " + threadLocal.get());
    }
}
