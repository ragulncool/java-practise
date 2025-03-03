package com.ragul.demo.Multithreading.synchronizationissues;

public class SyncIssue {
    public static void main(String args[]) throws InterruptedException {


        Counter counter = new Counter(); //counter is the shared resource across all threads

        SampleThread t1 = new SampleThread(counter);
        SampleThread t2 = new SampleThread(counter);
        SampleThread t3 = new SampleThread(counter);

        t1.start();
        t2.start();
        t3.start();

        // wait for threads to complete -  NO NEED - even when multiple threads are trying to access shared resource, only thread will be allowed and other will be in blocked
//        t1.join();
//        t2.join();
//        t3.join();

        }
    }




class SampleThread extends Thread{
    Counter counter;
    public SampleThread(Counter s) {
        counter=s;
    }

    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
        System.out.println("Value of Counter - " + counter.get()+" "+Thread.currentThread());
    }
}

class Counter {
    int counter = 1;

    public void increment() { //or use synchrionized in method level -  public synchronized void increment
        synchronized(this){   //synchronized block
            ++counter;
        }
    }

//    public void increment() { //unsync - values will be random - race condition
//            ++counter;
//    }

    public int get() {
        return counter;
    }
}

