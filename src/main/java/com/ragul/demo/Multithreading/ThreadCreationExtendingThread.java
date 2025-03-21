package com.ragul.demo.Multithreading;

public class ThreadCreationExtendingThread extends Thread { //DISAD: CANNPOT EXTEND MULTIPLE CLASSES- MULTIPLE INHERITANCE IS NOT SUPPORTED
    @Override
    public void run() {
        System.out.println("Current thread name: "
                + currentThread());    }
}

class MTDemo1{
public static void main(String args[]){
    ThreadCreationExtendingThread thread=new ThreadCreationExtendingThread();

    thread.run(); //doesnt create a new thread. just runs on main thread itself and no multi threadings takes place


    thread.start(); //start internally calls run
    //start is for creating new thread. run will be executed as a normal method


   // thread.start(); ERROR - ILLEGAL STATE EXCEPTION
    //start method can be called only once since thread already created but run can be called any number of times since it is a normal thread
}


}


