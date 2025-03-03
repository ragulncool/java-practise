package com.ragul.demo.Multithreading;

public class UnderstandingMultiThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            // it will sleep the main thread for 1 sec
            // ,each time the for loop runs
            //if we comment, output is rapid fast else will produce with 1 sec delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // This Thread.sleep() method will sleep the
            // thread 0.
            // printing the value of the variable
            System.out.println("Current thread name: "
                    + Thread.currentThread()+" "+i);
        }
    }
}

class MTDemo2{
public static void main(String args[]){
    UnderstandingMultiThread thread=new UnderstandingMultiThread();
    thread.start(); //start internally calls run
}


}


