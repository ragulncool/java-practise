package com.ragul.demo.Multithreading.advanced;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);  // Three permits

        for (int i = 0; i < 10; i++) {
            new Thread(new WorkerC(semaphore)).start();
        }
    }
}

        class WorkerC implements Runnable {
            private final Semaphore semaphore;

            WorkerC(Semaphore semaphore) {
                this.semaphore = semaphore;
            }

            @Override
            public void run() {
                try {
                    semaphore.acquire();  // Acquire a permit
                    System.out.println(Thread.currentThread().getName() + " is working.");
                    Thread.sleep((long) (Math.random() * 1000));  // Simulate work
                    System.out.println(Thread.currentThread().getName() + " has finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();  // Release the permit
                }
            }
        }


