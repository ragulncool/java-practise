package com.ragul.demo.Multithreading.advanced.CompletableFutureVsFuture;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
     //   ExecutorService executor = Executors.newFixedThreadPool(3); //to understand each future is a thread


        Future<Integer> futureResult = executor.submit(() -> {
            // Simulating a long-running task
            System.out.println("Starting future 1 "+Thread.currentThread());
            TimeUnit.SECONDS.sleep(2);
            return 42; // The result of the computation
        });
        Future<Integer> futureResult_2 = executor.submit(() -> {
            // Simulating a long-running task
            System.out.println("Starting future 2 "+Thread.currentThread());
            TimeUnit.SECONDS.sleep(2);
            return 42; // The result of the computation
        });
        futureResult_2.cancel(true);
        Integer result = futureResult.get(); // Blocking call
        System.out.println("Result of the computation: " + result);
        System.out.println(futureResult.isDone());
        System.out.println(futureResult_2.isCancelled());

    }
}
