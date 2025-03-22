package com.ragul.demo.java8;

import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<String> items = List.of("bat", "bat2", "bat3", "bat4", "bat5", "bat6", "bat7", "bat8", "bat9", "bat10");

        System.out.println("===PARALLEL STREAM===");
        items.parallelStream().forEach(x-> {
            System.out.println(Thread.currentThread());
        });

        System.out.println("===SEQUENTIAL STREAM===");
        items.stream().forEach(x-> {
            System.out.println(Thread.currentThread());
        });
    }
}
