package com.ragul.demo.Multithreading.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorFramework1 {

public static void main(String args[]) throws ExecutionException, InterruptedException {

ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    System.out.println("Available processors :"+Runtime.getRuntime().availableProcessors());

    //assigning task to executor service
    //ExecutorService can execute Runnable and Callable tasks.
    Runnable runnableTask = () -> {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Callable<String> callableTask = () -> {
        TimeUnit.MILLISECONDS.sleep(300);
        return "Returns Callable Task Execution";
    };

    List<Callable<String>> listOfCallableTask = new ArrayList<>();
    listOfCallableTask.add(callableTask);
    listOfCallableTask.add(callableTask);
    listOfCallableTask.add(callableTask);

    //2. SUBMIT PHASE
    executorService.execute(runnableTask);

    Future<String> future =
            executorService.submit(callableTask);
    System.out.println("submit(): "+future.get()+" "+Thread.currentThread().getName());

    String result = executorService.invokeAny(listOfCallableTask); //causing each to run, and returns the result of a successful execution of one task (if there was a successful execution):

    List<Future<String>> futures = executorService.invokeAll(listOfCallableTask); // assigns a collection of tasks to an ExecutorService, causing each to run, and returns the result of all task executions in the form of a list of objects of type Future:
   for(Future future1: futures){
       System.out.println("invokeAll(): "+future1.get()+" "+Thread.currentThread().getName());
   }


    //3. DESTRUCTION PHASE
    executorService.shutdown(); //IF WE DONT SHUTDOWN, SERVER WILL BE ALWAYS ON
}


}

class ThreadA1 implements Runnable{

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
