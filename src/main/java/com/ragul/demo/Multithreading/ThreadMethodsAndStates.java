package com.ragul.demo.Multithreading;

public class ThreadMethodsAndStates extends Thread {


    public ThreadMethodsAndStates(String thread_sample_name) {
        super(thread_sample_name);
    }

        public void run(){
            int count=1;

            while(true && count<10) //adding count< to avoid INF loop
            {
                System.out.println(count=count+2);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e);
                }
            }
        }
    }


class Threadtest{
    public static void main(String args[]) throws InterruptedException {
        System.out.println("===MAIN THREAD (BY DEFAULT AND IT ALWAYS EXIST)===");
        Thread currentThread = Thread.currentThread();
        System.out.println("Current Thread Name - " + currentThread.getName());
        System.out.println("Current Thread Priority - " + currentThread.getPriority());
        System.out.println("Current Thread Group - " + currentThread.getThreadGroup());
        System.out.println("Current Thread Id - " + currentThread.getId());
        System.out.println("Current Thread State - " + currentThread.getState());

        System.out.println("===CREATING THREAD===");
        JoinThread t=new JoinThread("T-NAME1");
        System.out.println("Name "+t.getName());
        System.out.println("Priority "+t.getPriority());
        System.out.println("State "+t.getState());
        System.out.println("Alive "+t.isAlive());

        System.out.println("===STARTING THREAD===");
        t.start();
        System.out.println("State "+t.getState());
        System.out.println("Alive "+t.isAlive());

        System.out.println("===INTERRUPT THREAD===");
        t.interrupt();//INTERRUPTED WHILE SLEEPING
        System.out.println("State "+t.getState());
        System.out.println("Alive "+t.isAlive());



//        System.out.println("===MAKING METHOD AS DAEMON===");
//        t.setDaemon(true);
        //t.start() will not work since daemon will kill when main method is executed

        ThreadMethodsAndStates t2=new ThreadMethodsAndStates("T-NAME2");
        t2.start();
        t.join();  //ALL OTHER THREADS INCLUDING MAIN WILL WAIT UNTIL T IS COMPLETED
        System.out.println("This line will be printed after join thread is completed (after 21)");
        System.out.println("===JOIN THREAD & TERMINATED THREAD==="); //while executing this t will have finished execution sincce t.join used
        System.out.println("State "+t.getState());
        System.out.println("Alive "+t.isAlive());
        System.out.println("State "+t2.getState());
        System.out.println("Alive "+t2.isAlive());

        t2.join(); //to clear console so that remaining thread t2 is executed
        System.out.println("===YIELD THREAD===");
        ThreadMethodsAndStates t3=new ThreadMethodsAndStates("T-NAME3");

        SamePriorityThread t4=new SamePriorityThread("T-NAME4");

        t3.start();
        t4.start();
        mainRun();
        //YIELD IS NOT WORKING. ONE OF T3 /T4 / MAIN SHOULD FINISH AND ONLY THEN OHTER 2 SHOULD EXECUTE
        Thread.yield(); // yield method caused to pause current executing thread to give the chance for waiting thread of same priority.
        // if there is no waiting thread or all waiting thread have low priority then same thread can continue it’s execution.
        System.out.println("State "+t3.getState());
        System.out.println("Alive "+t3.isAlive());
        System.out.println("State "+t4.getState());
        System.out.println("Alive "+t4.isAlive());
    }

    public static void mainRun(){
        int count=300;

        while(true && count<310) //adding count< to avoid INF loop
        {
            System.out.println(count=count+2);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println("main "+e);
            }
        }
    }
}

class SamePriorityThread extends Thread {


    public SamePriorityThread(String thread_sample_name) {
        super(thread_sample_name);
    }

    public void run(){
        int count=100;

        while(true && count<110) //adding count< to avoid INF loop
        {
            System.out.println(count=count+2);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}

class JoinThread extends Thread {


    public JoinThread(String thread_sample_name) {
        super(thread_sample_name);
    }

    public void run(){
        int count=200;

        while(true && count<210) //adding count< to avoid INF loop
        {
            System.out.println(count=count+2);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println("thread 2: "+e);
            }
        }
    }
}



