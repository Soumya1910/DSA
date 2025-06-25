package com.dsa.Thread.CompletableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class CompletableThenCompose {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started in background thread by " + Thread.currentThread().getName() + " at " + getCurrentTime());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Fetching user task is completed by " + Thread.currentThread().getName() +
                    " at "+ getCurrentTime());
            return "Soumya";
        }).thenCompose(result -> CompletableFuture.supplyAsync(() ->  {
            System.out.println("Task started in background thread by " + Thread.currentThread().getName() + " at " + getCurrentTime());
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Getting whistlist user list by thread -> " + Thread.currentThread().getName() + " at " + getCurrentTime());
                List<String> whistlistUserList = Arrays.asList("Ram", "Shyam", "Gopal");
                return String.valueOf(whistlistUserList.contains(result));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        future.thenAccept(result -> System.out.println("Result: " + result + " by " + Thread.currentThread().getName() + " at " + getCurrentTime()));

        future.join(); // Block the main thread until the future is completed
    }
}
