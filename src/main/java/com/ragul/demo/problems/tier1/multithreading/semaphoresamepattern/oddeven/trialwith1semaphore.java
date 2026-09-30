package com.ragul.demo.problems.tier1.multithreading.semaphoresamepattern.oddeven;

import java.util.concurrent.Semaphore;

public class trialwith1semaphore {
    //problem with single sempahore apparoach is it doesnt guarantee order
    //all t1 will execute then t2

//    One semaphore controls access, but does not control which thread gets access.
//    Two semaphores allow us to explicitly hand over the turn from one thread to the other.
//    That's the main reason the two-semaphore solution is preferred for alternating threads.

    static Semaphore odd = new Semaphore(1);

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                try {
                    odd.acquire();      // Odd thread gets permission
                    System.out.println(i);
                    odd.release();     // Give permission to even thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    odd.acquire();     // Even thread gets permission
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