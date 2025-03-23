package com.ragul.demo.Multithreading.advanced;

import org.apache.tomcat.util.digester.SystemPropertySource;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo { //LATCH - WAIT TILL LATCH (GATE) IS OPEN. ONE THREAD WAITS FOR N THREAD TO COMPLETE
    public static void main(String[] args) {
        // CountDownLatch is a synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
        // The count cannot be reset after it reaches zero.
        // The CountDownLatch class is thread-safe.
        // The CountDownLatch class is useful for implementing a timeout feature, where a thread waits for a set of operations to complete within a specified time limit.
        // The CountDownLatch class is useful for implementing a producer-consumer pattern, where a producer thread waits for a consumer thread to process a set of data.
        // The CountDownLatch class is useful for implementing a master-worker pattern, where a master thread waits for a set of worker threads to complete a set of tasks.
        // The CountDownLatch class is useful for implementing a parallel processing pattern, where a set of threads wait for a set of tasks to complete before proceeding to the next set of tasks.

        //STEPS
        // 1. A CountDownLatch is initialized with a given count.
        // 2. The await() method blocks until the count reaches zero, after which the waiting thread is released.
         //    TIMED AWAIT  - latch.await(1, TimeUnit.SECONDS)
        // 3. The count is decremented by calls to the countDown() method.

        //APPLICATION
        //Wait for several threads to finish their tasks before proceeding.

        //DISAD
        // is that it's not reusable: once count reaches zero you cannot use CountDownLatch any more.
            int threadCount = 3;
            CountDownLatch latch = new CountDownLatch(threadCount); //WAIT FOR 3 TASKS

            for (int i = 0; i < threadCount; i++) {
                new Thread(new Worker(latch)).start();
            }

            try {
                latch.await();  // Wait for all workers to finish OR             if (latch.await(1, TimeUnit.SECONDS)) {
                System.out.println("All workers have finished their tasks."+" "+Thread.currentThread().getName());

//                if (latch.await(1, TimeUnit.SECONDS)) {
//                    System.out.println("All workers finished within the timeout.");
//                } else {
//                    System.out.println("Timeout reached before all workers finished.");
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


class Worker implements Runnable {
    private final CountDownLatch latch;

    Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is working.");
            Thread.sleep((long) (Math.random() * 1000));  // Simulate work
            System.out.println(Thread.currentThread().getName() + " has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();  // Decrement the count
        }
    }
}
