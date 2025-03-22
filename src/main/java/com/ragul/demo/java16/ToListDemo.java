package com.ragul.demo.java16;

import java.util.List;

public class ToListDemo {

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        list.stream().filter(s -> s.equals("a")).toList(); //instead of Collectors(collect.toLit())
    }
}
