package com.ragul.demo.Multithreading;

public class DaemonThread extends Thread {


    public DaemonThread(String thread_sample_name) {
        super(thread_sample_name);
    }

        public void run(){
            int count=1;

            while(true)
            {
                System.out.println(count++);
//                try
//                {
//                    Thread.sleep(1000);
//                }
//                catch(InterruptedException e)
//                {
//                    System.out.println(e);
//                }
            }
        }
    }


class Threadtest1{
    public static void main(String args[]){
        System.out.println("===CREATING THREAD===");
        DaemonThread t=new DaemonThread("Thread sample name");


        System.out.println("===MAKING THREAD AS DAEMON===");
        t.setDaemon(true);
        t.start();;  //daemon thread will terminate when main is terminated
        //not clear about join and yield
    }
}
