package com.ragul.demo.Multithreading.advanced;

//CyclicBarrier is a synchronization aid that allows a set of threads
// to wait for each other to reach a common barrier point before any can proceed,

//Advantages
//1. CyclicBarrier is reusable, which means that it can be reset after the waiting threads are released unlike CountDownLatch.

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int threadCount = 3;
        //action to be performed when all threads reach the barrier;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("All threads reached the barrier!");
        });

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " is waiting at the barrier.");
                    barrier.await(); // Threads wait here
                    System.out.println("Thread " + Thread.currentThread().getId() + " passed the barrier.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
