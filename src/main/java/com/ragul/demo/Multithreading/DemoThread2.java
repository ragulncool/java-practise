package com.ragul.demo.Multithreading;

public class DemoThread2 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            // it will sleep the main thread for 1 sec
            // ,each time the for loop runs
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // This Thread.sleep() method will sleep the
            // thread 0.
            // printing the value of the variable
            System.out.println("Current thread name: "
                    + Thread.currentThread().getName()+" "+i);
        }
    }
}

class MTDemo2{
public static void main(String args[]){
    DemoThread2 thread=new DemoThread2();
    thread.start(); //start internally calls run
}


}


