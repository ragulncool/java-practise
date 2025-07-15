package com.ragul.demo.Multithreading.JavaEnsureThreadSafety;

//The volatile keyword in Java is used to indicate that a variable's value
// can be changed by multiple threads simultaneously
public class Volatile {
        private static volatile int counter = 0; //remove volatile keyword and check

        private static class Player extends Thread {
            @Override
            public void run() {
                // Simulate some game events
                for (int i = 0; i < 100; i++) {
                    // Update the counter
                    counter++;
                    System.out.println("Player updated counter: " + counter+" "+currentThread());
                }
            }
        }

        public static void main(String[] args) {
            // Create multiple player threads
            Player player1 = new Player();
            Player player2 = new Player();

            player1.start();
            player2.start();
        }
    }

