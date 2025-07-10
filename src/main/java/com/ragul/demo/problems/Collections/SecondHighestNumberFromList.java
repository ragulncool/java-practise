package com.ragul.demo.problems.Collections;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SecondHighestNumberFromList {
    public static void main(String[] args) {
        // Example list
        List<Integer> list = List.of(9,8,5,6,7,1,2,3);

        Set<Integer> set = new TreeSet<>(list);
        list = set.stream()
                .toList(); // Convert the Set back to a List

        System.out.println(list.get(list.size() - 2));

    }
}
