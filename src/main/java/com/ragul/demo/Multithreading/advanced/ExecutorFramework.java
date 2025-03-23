package com.ragul.demo.Multithreading.advanced;

import java.util.concurrent.*;

public class ExecutorFramework {

//    It will help in
//    Avoiding Manual Thread management
//    Resource management
//    Scalability
//    Thread reuse
//    Error handling

    //Advantage
    //automatically creates thread object and calls start method
    //whenever threads are created, there is overhead. here thread pool is used where threads are recycled instead of creating new on


    //Thread pool - number of concurrently running task. Once any one completes, new task is taken by the free thread instead of creating new one
public static void main(String args[]) throws ExecutionException, InterruptedException {

    //1. INITILIZATION PHASE
    //ExecutorService executorService = Executors.newFixedThreadPool(3); //3 an run simulatenously. others will wait and start once any 1 is completed
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    System.out.println("Available processors :"+Runtime.getRuntime().availableProcessors());
    //ExecutorService executorService = Executors.newCachedThreadPool(); //all will start parallely
   // ExecutorService executorService = Executors.newSingleThreadExecutor(); //only one task is executed once


    //2. SUBMIT PHASE
    for(int i=1;i<=4;i++){
        executorService.execute(()->{
            System.out.println("execute()   "+Thread.currentThread().getName());
        }); // newFixedThreadPool - 4th thread will start if one thread is completed
    }

    //use submit instead of execute to return eg: status
    for(int i=1;i<=4;i++){
        Future<?> future = executorService.submit(()->{
            System.out.println("submit()    "+Thread.currentThread().getName());
            return 123;
        }); // newFixedThreadPool - 4th thread will start if one thread is completed
        System.out.println("Future return: "+future.get()+"     "+Thread.currentThread().getName());
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
