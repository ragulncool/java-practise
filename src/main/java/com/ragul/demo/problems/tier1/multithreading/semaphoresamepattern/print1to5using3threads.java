package com.ragul.demo.problems.tier1.multithreading.semaphoresamepattern;

import java.util.concurrent.Semaphore;

public class print1to5using3threads {

    static Semaphore sem1 = new Semaphore(1);
    static Semaphore sem2 = new Semaphore(0);
    static Semaphore sem3 = new Semaphore(0);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 15; i += 3) {
                try {
                    sem1.acquire();

                    System.out.println(i);

                    sem2.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 15; i += 3) {
                try {
                    sem2.acquire();

                    System.out.println(i);

                    sem3.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 3; i <= 15; i += 3) {
                try {
                    sem3.acquire();

                    System.out.println(i);

                    sem1.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}