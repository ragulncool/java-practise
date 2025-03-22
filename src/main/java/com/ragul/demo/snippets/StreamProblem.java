package com.ragul.demo.snippets;

import java.util.List;

//Given an Array, remove all odd numbers, multiple each number by a constant and then return sum.
public class StreamProblem {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list = list.stream().filter(x-> x%2==1).map(x->x*2).toList();
        System.out.println(list);
    }
}
