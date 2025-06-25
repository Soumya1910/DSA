package com.dsa.Thread.ThreadPoolExecutor;

import java.util.concurrent.*;

import static com.dsa.Thread.TimeUtility.getCurrentTime;

public class MainClass {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());
        System.out.println("Main Thread --> " + Thread.currentThread().getName() + " at " + getCurrentTime() + " " +
                "started.");
        poolExecutor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 7; i++) {
            int finalI = i;
            poolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Task " + (finalI + 1) + " --> " + Thread.currentThread().getName() + " submitted" +
                            " at " + getCurrentTime());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        poolExecutor.shutdown();
        System.out.println("Main Thread --> " + Thread.currentThread().getName() + " at " + getCurrentTime() + " " +
                "stopped.");
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(false);
        return thread;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Rejected task: " + r.toString() + " at " + getCurrentTime() + " by " + executor.toString() + ".");
    }
}

