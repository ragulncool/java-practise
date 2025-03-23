package com.ragul.demo.Multithreading.advanced;

import java.util.concurrent.Semaphore;

//Semaphores are particularly useful in scenarios where you need to limit the number of concurrent accesses (thread)
// to a shared resource.

//STEPS
//1. A Semaphore is initialized with a given number of permits.
//2. The acquire() method blocks until a permit is available, after which the permit is acquired.
//3. The release() method releases a permit, increasing the number of available permits by one.
//    The number of permits is decremented by calls to the acquire() method and incremented by calls to the release() method.

//APPLICATION
//1. implement rate limiting, controlling the number of tasks processed concurrently.
//2. Database Connection Pool
//Consider a scenario where you need to manage a fixed number of database connections

//AD
//multiple times permit can be acquired an drelease unlike CountDownLatch which is one time use
//Fairness Guarantee - FIFO order
public class SemaphoreDemo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);  // Three permits
       // TimedSemaphore semaphore = new TimedSemaphore(period, TimeUnit.SECONDS, slotLimit);
        //after this period the time reset and all permits are released.


        for (int i = 0; i < 5; i++) {
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


