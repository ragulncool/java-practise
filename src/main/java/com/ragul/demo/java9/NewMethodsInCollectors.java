package com.ragul.demo.java9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewMethodsInCollectors {

    public static void main(String[] args) {
        List<String> names = Stream.of("Alice", "Bob", "Charlie", "David")
                .collect(Collectors.filtering(name -> name.startsWith("A"), Collectors.toList()));
        System.out.println(names);
    }

}
