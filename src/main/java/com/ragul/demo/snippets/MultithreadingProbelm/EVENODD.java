package com.ragul.demo.snippets.MultithreadingProbelm;

//Write a program to print numbers from 1 to 100 using two threads with one thread printing odd numbers and one thread printing even numbers
public class EVENODD {
        private int number = 1;
        private final int MAX = 100;

        // Method for odd thread
        public synchronized void printOdd() throws InterruptedException {
            while (number < MAX) {
                // If number is even, wait for even thread to print
                while (number % 2 == 0) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " - " + number);
                number++;  // Increment after printing
                notify();  // Notify the other thread to continue
            }
        }

        // Method for even thread
        public synchronized void printEven() throws InterruptedException {
            while (number <= MAX) {
                // If number is odd, wait for odd thread to print
                while (number % 2 != 0) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " - " + number);
                number++;  // Increment after printing
                notify();  // Notify the other thread to continue
            }
        }
    }

     class Main{
        public static void main(String[] args) {
            EVENODD printNumbers = new EVENODD();

            // Odd number thread
            Thread oddThread = new Thread(() -> {
                try {
                    printNumbers.printOdd();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Odd Thread");

            // Even number thread
            Thread evenThread = new Thread(() -> {
                try {
                    printNumbers.printEven();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Even Thread");

            // Start both threads
            oddThread.start();
            evenThread.start();
        }
    }

