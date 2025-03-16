package com.ragul.demo.java9;

import java.util.stream.Stream;

public class NewStreamMethods {

    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Take numbers while they are less than 5
//        numbers.takeWhile(n -> n < 5)
//                .forEach(System.out::println);

        numbers.dropWhile(n -> n < 5)
                .forEach(System.out::println);
    }

 //new - ofNullable, iterate,
}
