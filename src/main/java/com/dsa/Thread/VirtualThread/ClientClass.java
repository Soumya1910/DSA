package com.dsa.Thread.VirtualThread;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ClientClass {
    public static void main(String[] args) {
        int taskCount = 100;

        Instant startTime = Instant.now();
        executePlatformThread(taskCount);
        Instant endTime = Instant.now();
        System.out.println("Total time taken by Platform Thread: " + Duration.between(startTime, endTime).toMillis() + " milliseconds");
        Instant startTime1 = Instant.now();
        executeVirtualThread(taskCount);
        Instant endTime1 = Instant.now();
        System.out.println("Total time taken by Virtual Thread: " + Duration.between(startTime1, endTime1).toMillis() + " milliseconds");
        Instant startTime2 = Instant.now();
        executeVirtualThreadWithTotalTime(taskCount);
        Instant endTime2 = Instant.now();
        System.out.println("Total time taken by Virtual Thread after completing all the threads: " + Duration.between(startTime2, endTime2).toMillis() + " milliseconds");

    }

    public static void executePlatformThread(int taskCount) {
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            futureList.add(future);
        }
        // Wait for all tasks to complete
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
    }

    public static void executeVirtualThread(int taskCount) {
        for(int i = 0; i < taskCount; i++) {
            Thread.ofVirtual().start(() -> {
                try {
                    Thread.sleep(1000); // Simulate task with 1000 ms sleep
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }


    public static void executeVirtualThreadWithTotalTime(int taskCount) {
        CountDownLatch latch = new CountDownLatch(taskCount);
        for(int i = 0; i < taskCount; i++) {
            Thread.ofVirtual().start(() -> {
                try {
                    Thread.sleep(1000); // Simulate task with 1000 ms sleep
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    latch.countDown(); // Decrement the latch count when the task completes
                }
            });
        }

        try {
            latch.await(); // Wait for all tasks to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

