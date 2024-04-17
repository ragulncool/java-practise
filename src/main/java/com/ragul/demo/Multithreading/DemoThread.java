package com.ragul.demo.Multithreading;

public class DemoThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread started");
    }
}

class MTDemo {
public static void main(String args[]){
    DemoThread thread=new DemoThread();
    thread.run();
}


}


