package com.ragul.demo.Multithreading.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {

    //Advantage
    //automatically creates thread object and calls start method
    //whenever threads are created, there is overhead. here thread pool is used where threads are recycled instead of creating new one

    //Thread pool - number of concurrently running task. Once any one completes, new task is taken by the free thread instead of creating new one
public static void main(String args[]){

    //1. INITILIZATION PHASE
    //ExecutorService executorService = Executors.newFixedThreadPool(3); //3 an run simulatenously. others will wait and start once any 1 is completed
    //ExecutorService executorService = Executors.newCachedThreadPool(); //all will start parallely
    ExecutorService executorService = Executors.newSingleThreadExecutor(); //only one task is executed once


    //2. SUBMIT PHASE
    for(int i=1;i<=4;i++){
        executorService.execute(new ThreadA()); // newFixedThreadPool - 4th thread will start if one thread is completed
    }

    //3. DESTRUCTION PHASE
    executorService.shutdown(); //IF WE DONT SHUTDOWN, SERVER WILL BE ALWAYS ON
}


}

class ThreadA implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread is started");

        for(int i=1;i<=10;i++){
            System.out.println(i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread is completed");
    }

}
