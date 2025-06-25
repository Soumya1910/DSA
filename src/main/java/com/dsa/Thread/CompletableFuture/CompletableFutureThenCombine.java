package com.dsa.Thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class CompletableFutureThenCombine {
    public static void main(String[] args) {

    }

    public static CompletableFuture<String> getUserEmail(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Get User email started in background thread by " + Thread.currentThread().getName()+ " at " + getCurrentTime());
            try {
                TimeUnit.SECONDS.sleep(2);
                return "rivu10@gmail.com";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
