package com.ragul.demo.Multithreading;

public class DemoThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Current thread name: "
                + Thread.currentThread().getName());
    }
}

class MTDemo {
public static void main(String args[]){
    DemoThread demoThread=new DemoThread();
    Thread thread = new Thread(demoThread);
    thread.start();
}


}


