package com.ragul.demo.snippets.MultithreadingProbelm;

//Write a Multithreading problem which creates 3 threads (T1, T2, T3) and every thread should run in such a sequential manner that the output is like:
//T1:1
//T2:2
//T3:3
//        …..
//T1:10
public class Multithreading {
    static int counter=0;

    static synchronized void incrementCounter() {

            counter++;
            System.out.println(counter+" "+Thread.currentThread());
    }

    public static void main(String[] args) {
        Thread1 t1=new Thread1();
        t1.start();
        Thread2 t2=new Thread2();
        t2.start();
        Thread3 t3=new Thread3();
        t3.start();
    }
}

class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Multithreading.incrementCounter();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Thread2 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Multithreading.incrementCounter();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
class Thread3 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Multithreading.incrementCounter();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }    }
}