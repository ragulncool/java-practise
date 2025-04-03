package com.ragul.demo.Multithreading.advanced;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//bank Account
public class Locks {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int withdrawAmount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + withdrawAmount);
        try {
            //Acquires the lock if it is free within the given waiting time
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
           // lock.lock(); //Lock is acquired and other thread will wait for lock to release indefinitely
                if (balance >= withdrawAmount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000); // Simulate time taken to process the withdrawal
                        balance -= withdrawAmount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock within timeline, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void understandLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to understand lock");
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " acquired the lock");
                Thread.sleep(3000); // Simulate time taken for operation
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released the lock");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not acquire the lock");
        }
    }
}
 class TestLocks {
    public static void main(String[] args) throws InterruptedException {
        Locks sbi = new Locks();
        Runnable task = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                sbi.understandLock(); //1. basic lock understanding or
               // sbi.withdraw(50); //2. practicalApplication
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        //Thread.sleep(3000); IF UNCOMMENTED -  WILL WAIT 3KMS AND T2 WILL CHECK LOCK.
        //SINCE T1 ALREADY COMEPLETED, T2 WITHDRAW WILL BE SUCCESS
        t2.start();
    }
}

