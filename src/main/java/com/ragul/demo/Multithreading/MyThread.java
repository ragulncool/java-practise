package com.ragul.demo.Multithreading;

public class MyThread extends Thread
{
    public void run()
    {
        System.out.println(currentThread()+" r1 ");
        try {
            Thread.sleep(500);
        }catch(InterruptedException ie){ }
        System.out.println(currentThread()+" r2 ");
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        t1.start();


        //t1.join();	//Waiting for t1 to finish

        t2.start();
    }
}