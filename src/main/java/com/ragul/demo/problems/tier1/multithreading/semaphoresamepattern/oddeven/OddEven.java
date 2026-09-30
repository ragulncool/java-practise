package com.ragul.demo.problems.tier1.multithreading.semaphoresamepattern.oddeven;

import java.util.concurrent.Semaphore;

public class OddEven {

    static Semaphore odd = new Semaphore(1);
    static Semaphore even = new Semaphore(0);

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                try {
                    odd.acquire();      // Odd thread gets permission
                    System.out.println(i);
                    even.release();     // Give permission to even thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    even.acquire();     // Even thread gets permission
                    System.out.println(i);
                    odd.release();      // Give permission to odd thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}