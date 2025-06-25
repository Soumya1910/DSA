package com.dsa.Thread;

import java.util.ArrayList;
import java.util.List;

public class BufferResource {
    private final int bufferSize = 10;
    private List<Integer> resourceList = new ArrayList<>(bufferSize);

    /**
     * Adds random integers to the buffer until it reaches its maximum capacity.
     * <p>
     * This method is synchronized to ensure thread safety. If the buffer is full,
     * the calling thread will wait until space becomes available. Once the buffer
     * is filled, all waiting threads are notified.
     * </p>
     */
    public synchronized void add() {
        System.out.println("Waiting for producer to fill the buffer..."+ Thread.currentThread().getName());
        while(resourceList.size() == bufferSize) {
            System.out.println("Buffer is full, waiting for consumer to remove an item...  ");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while(resourceList.size() < bufferSize) {
            int randomNumber = (int) (Math.random() * 100);
            resourceList.add(randomNumber);
            System.out.println("Added: " + randomNumber + " to buffer");
        }
        notifyAll();
        System.out.println("All threads notified, current buffer size is: " + resourceList.size() + " exited the add " +
                "method  " + Thread.currentThread().getName());

    }

    /**
     * Removes all integers from the buffer until it is empty.
     * <p>
     * This method is synchronized to ensure thread safety. If the buffer is empty,
     * the calling thread will wait until an item is added by the producer. Once the
     * buffer is emptied, all waiting threads are notified.
     * </p>
     */
    public synchronized void remove() {
        System.out.println("Waiting for consumer to consume from the buffer..."+ Thread.currentThread().getName());
        while(resourceList.isEmpty()) {
            try {
                System.out.println("Buffer is empty, waiting for producer to add an item...  ");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while(resourceList.size() > 0) {
            int removedNumber = resourceList.removeFirst();
            System.out.println("Removed: " + removedNumber + " from buffer and current buffer size is: " + resourceList.size());
        }
        notifyAll();
        System.out.println("All threads notified, current buffer size is: " + resourceList.size() + " exited the " +
                "remove " +Thread.currentThread().getName());
    }
}
