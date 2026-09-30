package com.ragul.demo.Multithreading;

import static java.lang.Thread.currentThread;

public class ThreadCreatingUsingRnnableLamdaExp {
    public static void main(String args[]){
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(currentThread()+ " has started");
//
//            }
//        };
//        Thread thread = new Thread(runnable);
        Thread thread = new Thread(new DemoThread());
        thread.start();
        }
    }

//SIMPLILIED USING LAMDA EXPRESSION ABOVE

class DemoThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside RUN method Thread has started "+currentThread().getName());
    }
}