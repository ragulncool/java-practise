package com.ragul.demo.Multithreading;

public class Synchronized {

    synchronized void printTable(int n) {
            for(int i = 1; i <= 5; i++) {
                // Print the multiplication result
                System.out.println(n * i);
                try {
                    // Pause execution for 400 milliseconds
                    Thread.sleep(400);
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
    class MyThread1 extends Thread {
        Synchronized t;
        // Constructor to initialize Table object
        MyThread1(Synchronized t) {
            this.t = t;
        }
        // Run method to execute thread
        public void run() {
            t.printTable(5);
        }
    }
    class MyThread2 extends Thread {
        Synchronized t;
        MyThread2(Synchronized t) {
            this.t = t;
        }
        public void run() {
            t.printTable(100);
        }
    }

class TestSynchronization {
    public static void main(String args[]) {
        Synchronized obj = new Synchronized();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        // Start both threads
        t1.start();
        t2.start();
    }
}

