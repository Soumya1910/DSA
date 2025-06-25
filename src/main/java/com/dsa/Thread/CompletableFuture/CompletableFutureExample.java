package com.dsa.Thread.CompletableFuture;

import java.util.concurrent.*;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardOldestPolicy());
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task started in background thread by " + Thread.currentThread().getName() + " at " + getCurrentTime());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Task completed in background thread by " + Thread.currentThread().getName() + "at" + getCurrentTime());
                return "Hello, CompletableFuture!";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }, executor); // Submit the task to the ThreadPoolExecutor

        CompletableFuture completableFuture1 = completableFuture.thenApply(result -> {
            System.out.println("Result processed by " + Thread.currentThread().getName() + " at " + getCurrentTime() + " - " + result);
            return result + " World!";
        });

        CompletableFuture<String> completableFuture2 = completableFuture.thenApplyAsync(result -> {
            System.out.println("Result processed by " + Thread.currentThread().getName() + " at " + getCurrentTime() + " - " + result);
            return result + "Async!";
        });

        String str = completableFuture2.get(); // Blocks until the result is available
        System.out.println("Main thread received result: " + str + " by " + Thread.currentThread().getName() + " at " + getCurrentTime());
    }
}