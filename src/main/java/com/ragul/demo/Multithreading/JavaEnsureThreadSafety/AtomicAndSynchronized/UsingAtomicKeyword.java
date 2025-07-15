package com.ragul.demo.Multithreading.JavaEnsureThreadSafety.AtomicAndSynchronized;

import java.util.concurrent.atomic.AtomicInteger;

//change - atomic keyword for count var
//count.addAndGet(1); instead of count++;
    class CounterSyn1 extends Thread {

        // Counter Variable
        //int count = 0;

        AtomicInteger count;

        public CounterSyn1() {
            count = new AtomicInteger(0);
        }

        public  void run()
        {
            int max = 100000000;

            for (int i = 0; i < max; i++) {
               count.addAndGet(1); //count++;
            }
        }
    }

    public class UsingAtomicKeyword {
        public static void main(String[] args)
                throws InterruptedException
        {
            CounterSyn1 c = new CounterSyn1();

            Thread first = new Thread(c, "First");
            Thread second = new Thread(c, "Second");

            first.start();
            second.start();

            first.join();
            second.join();

            System.out.println(c.count);
        }
    }
