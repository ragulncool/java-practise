package com.ragul.demo.snippets.MultithreadingProbelm;

//Write a Multithreading problem which creates 3 threads (T1, T2, T3) and every thread should run in such a sequential manner that the output is like:
//T1:1
//T2:2
//T3:3
//        …..
//T1:10
public class Multithreading1 {
    static int counter=0;

    static synchronized void incrementCounter() {

            counter++;
            System.out.println(counter+" "+Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread11 t1=new Thread11();
        t1.start();
        t1.join();
        Thread11 t2=new Thread11();
        t2.start();
        t2.join();
        Thread11 t3=new Thread11();
        t3.start();
        t3.join();
        while (counter<10){
            t1.run();
            t1.join();
            t2.run();
            t2.join();
            t3.run();
            t3.join();
        }
    }
}

class Thread11 extends Thread {
    public void run() {
        Multithreading.incrementCounter();

    }
}
//class Thread12 extends Thread {
//    public void run() {
//        Multithreading.incrementCounter();
//    }
//}
//class Thread13 extends Thread {
//    public void run() {
//        Multithreading.incrementCounter();
//
//    }
//}