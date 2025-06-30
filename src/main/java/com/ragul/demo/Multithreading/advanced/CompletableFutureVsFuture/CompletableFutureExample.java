package com.ragul.demo.Multithreading.advanced.CompletableFutureVsFuture;

import java.util.concurrent.CompletableFuture;

//// CompletableFuture is a class in Java that represents a future result of an asynchronous computation.
//// It allows you to write non-blocking code and handle the result of a computation when it becomes available.
public class CompletableFutureExample {
    public static void main(String[] args){

        //1. SIMPLE COMPLETABLE FUTURE THAT DOES NOT RETURN ANYTHING - runAsync
        CompletableFuture<Void> future_1 = CompletableFuture.runAsync(() -> {
            System.out.println("Running asynchronously... "+Thread.currentThread());
            // Simulate a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        future_1.join(); // Wait for the task to complete
        System.out.println("future_1 Task completed. "+Thread.currentThread());


        //2. SIMPLE COMPLETABLE FUTURE THAT RETURNS SOMETHING - supplyAsync
        CompletableFuture<Integer> future_2 = CompletableFuture.supplyAsync(() -> {
            // Simulate a computation
            return 5 * 5;
        });

        future_2.thenAccept(result -> {
            System.out.println("The result of future_2 is: " + result);
        }).join();


        //3. COMBINE TWO COMPLETABLE FUTURES
        CompletableFuture<Integer> future_3 = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<Integer> future_4 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> combinedFuture = future_3.thenCombine(future_4, (result1, result2) -> result1 + result2);

        combinedFuture.thenAccept(result -> {
            System.out.println("Combined result 3 and 4: " + result);
        }).join();

        //4. WAIT TILL BOTH FUTURE COMPLETES
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(future_3, future_4);

        allOfFuture.join(); // Wait for all futures to complete
        System.out.println("All tasks completed.");

        //5. HANDLE EXCEPTION - USING exceptionally
        CompletableFuture<Object> future_5 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Something went wrong - future_5 !");
        }).exceptionally(ex -> {
            System.out.println("Exception occurred: future_5 -  " + ex.getMessage());
            return null;
        });

        future_5.join();
    }
}