package com.ragul.demo.Multithreading.ThreadSafety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    // WITHOUT AtomicInteger
    static class WithoutAtomic {
        int count = 0;

        void increment() {
            count++;
        }
    }

    // WITH AtomicInteger
    static class WithAtomic {
        AtomicInteger count = new AtomicInteger(0);

        void increment() {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // WITHOUT AtomicInteger
        WithoutAtomic obj1 = new WithoutAtomic();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                obj1.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                obj1.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Without AtomicInteger: " + obj1.count);


        // WITH AtomicInteger
        WithAtomic obj2 = new WithAtomic();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                obj2.increment();
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                obj2.increment();
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("With AtomicInteger: " + obj2.count);
    }
}