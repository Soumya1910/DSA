package com.dsa.Thread;

public class ClientClass {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("Creating producer and consumer threads...  ");
        Thread producerThread = new Thread(() -> {
            try { // Sleep for 2 seconds to simulate production time
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } // sleep time is added to make sure that consumer thread starts first
            sharedResource.addItem();
        }, "Producer Thread");

        Thread consumerThread = new Thread(() -> {
            sharedResource.consumeItem();
        }, "Consumer Thread");
        producerThread.start();
        consumerThread.start();
    }
}
