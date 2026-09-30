package com.ragul.demo.problems.tier1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElementsInList {
    public static void main(String[] args) {
        Set<Integer> set= new HashSet<>();

        List<Integer> list = List.of(1, 2, 3, 4, 5, 1, 2, 3);
         List<Integer> dupList = list.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
        System.out.println(dupList);
    }
}
