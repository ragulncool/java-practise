package com.ragul.demo.problems.tier1.multithreading.semaphoresamepattern;

import java.util.concurrent.Semaphore;

public class ABC {

    static Semaphore semA = new Semaphore(1);
    static Semaphore semB = new Semaphore(0);
    static Semaphore semC = new Semaphore(0);


    public static void main(String[] args) {

        Thread A = new Thread(() -> {
            for (int i = 1; i <= 3; i ++) {

                try {
                    semA.acquire();      // Odd thread gets permission
                    System.out.println('A');
                    semB.release();     // Give permission to even thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread B = new Thread(() -> {
            for (int i = 1; i <= 3; i ++) {

                try {
                    semB.acquire();     // Even thread gets permission
                    System.out.println('B');
                    semC.release();      // Give permission to odd thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread C = new Thread(() -> {
            for (int i = 1; i <= 3; i ++) {

                try {
                    semC.acquire();     // Even thread gets permission
                    System.out.println('C');
                    semA.release();      // Give permission to odd thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        A.start();
        B.start();
        C.start();
    }
}