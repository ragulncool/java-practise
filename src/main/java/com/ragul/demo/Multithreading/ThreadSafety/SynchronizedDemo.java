package com.ragul.demo.Multithreading.ThreadSafety;

public class SynchronizedDemo {

    // WITHOUT synchronized
    static class WithoutSync {
        int count = 0;

        void increment() {
            count++;
        }
    }

    // WITH synchronized
    static class WithSync {
        int count = 0;

        synchronized void increment() {
            count++;
        }
    }

    // Thread class for WithoutSync
    static class WithoutSyncThread extends Thread {
        private final WithoutSync counter;

        WithoutSyncThread(WithoutSync counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        }
    }

    // Thread class for WithSync
    static class WithSyncThread extends Thread {
        private final WithSync counter;

        WithSyncThread(WithSync counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // Without synchronized
        WithoutSync withoutSync = new WithoutSync();

        Thread t1 = new WithoutSyncThread(withoutSync);
        Thread t2 = new WithoutSyncThread(withoutSync);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("WithoutSync count = " + withoutSync.count);


        // With synchronized
        WithSync withSync = new WithSync();

        Thread t3 = new WithSyncThread(withSync);
        Thread t4 = new WithSyncThread(withSync);

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("WithSync count    = " + withSync.count);
        System.out.println("Expected 200000");
    }


//    Without synchronized: Multiple threads can modify shared data simultaneously, causing race conditions and incorrect results.
//    (loses updated value before increment)

//    With synchronized: Only one thread at a time can modify the shared data, preventing race conditions and ensuring visibility.
    //Thread 1 → acquires lock → count++ → releases lock
    //Thread 2 → acquires lock → count++ → releases lock

//    Real-time example: Bank account
//    Without synchronized: Two ATM transactions withdraw ₹5,000 simultaneously → both read the same balance → incorrect balance.
//    With synchronized: Only one withdrawal executes at a time → balance remains correct and consistent.
}