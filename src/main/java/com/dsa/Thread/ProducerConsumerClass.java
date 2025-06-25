package com.dsa.Thread;

public class ProducerConsumerClass {
    /**
     * The main method serves as the entry point for the Producer-Consumer application.
     * It initializes a shared buffer resource and creates two threads: one for producing
     * items and another for consuming items. The threads are started to demonstrate
     * concurrent access to the shared resource.
     *
     * @param args Command-line arguments passed to the program. This method does not
     *             utilize any command-line arguments.
     */
    public static void main(String[] args) {
        BufferResource bufferResource = new BufferResource();

        Thread producerThread = new Thread(() -> {
            for(int i=0; i<5; i++) {
                bufferResource.add();
            }
        },"Producer-0");
        Thread consumerThread = new Thread(() -> {
            for(int i=0; i<5; i++) {
                bufferResource.remove();
            }
        },"Consumer-0");

        consumerThread.start();
        producerThread.start();
    }
}
