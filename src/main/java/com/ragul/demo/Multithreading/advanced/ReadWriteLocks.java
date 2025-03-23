package com.ragul.demo.Multithreading.advanced;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock(); //default fairness is false
    //fair lock - new ReentrantReadWriteLock(true);
    //fair lock ensures that threads acquire the lock in the order they requested it,
    // preventing thread starvation. With a fair lock, if multiple threads are waiting,
    // the longest-waiting thread is granted the lock next. However,
    // fairness can lead to lower throughput due to the overhead of maintaining the order.
    // Non-fair locks, in contrast, allow threads to “cut in line,” potentially offering better performance but at the risk of some threads waiting indefinitely if others frequently acquire the lock.
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock(); // if lock is not present, will wait for lock
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
       readLock.lock(); //if we remove read lock, all ready will be done in same time before write
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLocks counter = new ReadWriteLocks();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented ");
                }
            }
        };

        Thread writerThread1 = new Thread(writeTask);
        Thread writerThread2 = new Thread(writeTask);
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);

        writerThread1.start();
        writerThread2.start();
        readerThread1.start();
        readerThread2.start();

        //print last after all threads are completed
        writerThread1.join();
        writerThread2.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}