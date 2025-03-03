package com.ragul.demo.Multithreading;

public class ThreadCreationImplemenRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Current thread name: "
                + Thread.currentThread());
    }
}

class MTDemo {
public static void main(String args[]){
    ThreadCreationImplemenRunnable threadCreationImplemenRunnable =new ThreadCreationImplemenRunnable();
    Thread thread = new Thread(threadCreationImplemenRunnable);
    thread.start();
}


}


