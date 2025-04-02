package com.ragul.demo.Multithreading.advanced;


import java.util.concurrent.Callable;

// Runnable vs Callable
//runnable is void and callable is return type
// USE CASE: WHEN WE DONT WORRY ABOUT RESULT
// runnable cannot throw checked exception but callable can throw checked exception
// runnable can be used in executor framework but callable cannot be used in executor framework

// Runnable example
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running Runnable task");
    }
}

// Callable example
class MyCallable1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Running Callable1 task");
        return "Result from Callable";
    }
}

class MyCallable2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        throw new RuntimeException("Exception from Callable");
    }
}

class RunnableVsCallable {
    public static void main(String[] args) throws Exception {
        // Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        // Callable
        MyCallable1 myCallable1 = new MyCallable1();
        System.out.println("Callable1 task result: " + myCallable1.call());

        MyCallable2 myCallable2 = new MyCallable2();
        System.out.println("Callable2 task result: " + myCallable2.call());
    }
}
