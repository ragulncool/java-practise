package com.ragul.demo.Multithreading.synchronizationissues;

public class DeadLockExample2 {

        public static void main(String[] args) {
            DeadLockExample2 test = new DeadLockExample2();

            final A a = test.new A();
            final B b = test.new B();

            // Thread-1
            Runnable block1 = new Runnable() {
                public void run() {
                    synchronized (a) {
                        try {
                            // Adding delay so that both threads can start trying to
                            // lock resources
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // Thread-1 have A but need B also
                        synchronized (b) {
                            System.out.println("In block 1");
                        }
                    }
                }
            };

            // Thread-2
            Runnable block2 = new Runnable() {
                public void run() {
                    synchronized (b) {
                        // Thread-2 have B but need A also
                        synchronized (a) {
                            System.out.println("In block 2");
                        }
                    }
                }
            };

            new Thread(block1).start();
            new Thread(block2).start();
        }

        // Resource A
        private class A {
            private int i = 10;
        }

        // Resource B
        private class B {
            private int i = 20;
        }
    }

//To fix deadlock:
//CHangee in any one - synchroized block outisde so that doesnt wait for another thrrad acquiring one
//https://howtodoinjava.com/java/multi-threading/writing-a-deadlock-and-resolving-in-java/