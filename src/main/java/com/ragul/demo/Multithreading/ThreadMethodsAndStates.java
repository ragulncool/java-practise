package com.ragul.demo.Multithreading;

public class ThreadMethodsAndStates extends Thread {


    public ThreadMethodsAndStates(String thread_sample_name) {
        super(thread_sample_name);
    }

        public void run(){
            int count=1;

            while(true)
            {
                System.out.println(count++);
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
    public static void main(String args[]){
        System.out.println("===CREATING THREAD===");
        ThreadMethodsAndStates t=new ThreadMethodsAndStates("Thread sample name");
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

        System.out.println("===MAKING METHOD AS DAEMON===");
        t.setDaemon(true);
        //t.start() will not work since daemon will kill when main method is executed
    }
}
