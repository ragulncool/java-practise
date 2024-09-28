package com.ragul.demo.Multithreading;

public class ThreadCreatingUsingRnnableLamdaExp {
    public static void main(String args[]){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread has started");

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        }
    }

//SIMPLILIED USING LAMDA EXPRESSION ABOVE

//class DemoThread implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("Thread has started");
//    }
//}