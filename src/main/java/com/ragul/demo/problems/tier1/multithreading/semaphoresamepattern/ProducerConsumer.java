package com.ragul.demo.problems.tier1.multithreading.semaphoresamepattern;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    //synchronized + wait and notify

    static Queue<Integer> queue = new LinkedList<>();
    static int capacity = 5;

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (queue) {
                    try {
                        while (queue.size() == capacity) {
                            queue.wait();
                        }

                        queue.add(i);
                        System.out.println("Produced: " + i);

                        queue.notifyAll();

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (queue) {
                    try {
                        while (queue.isEmpty()) {
                            queue.wait();
                        }

                        int value = queue.poll();
                        System.out.println("Consumed: " + value);

                        queue.notifyAll();

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}