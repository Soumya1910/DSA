package com.dsa.Thread.join;

public class MainClass {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        System.out.println("Main thread started..");

        Thread thread1 = new Thread(() -> {
            sharedResource.waitingForSomeTimes();
            System.out.println("Thread 1 completed its execution");
        });
        thread1.start();

        // Wait for thread 1 to complete before main thread starts
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread completed it's execution");
    }
}
