package com.ragul.demo.Multithreading;

    class Counter {
        private int count = 0; // shared resource

//        public  void increment() { Without synch keyword - op will be random and not 2000
//            count++;
//        }

//        This results in a race condition when both threads try to increment the count variable concurrently.
//
//        Without synchronization, one thread might read the value of count before the other thread
//        has finished writing its incremented value. This can lead to both threads reading the same value,
//        incrementing it, and writing it back, effectively losing one of the increments.

        public synchronized void increment() { //op will be 2000 since race condition is avoided - one thread can access at a time
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public class MyThreadSync extends Thread {
        private Counter counter;

        public MyThreadSync(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }

        public static void main(String[] args) {
            Counter counter = new Counter();
            MyThreadSync t1 = new MyThreadSync(counter);
            MyThreadSync t2 = new MyThreadSync(counter);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            }catch (Exception e){

            }
            System.out.println(counter.getCount()); // Expected: 2000, Actual will be random <= 2000
        }
}
