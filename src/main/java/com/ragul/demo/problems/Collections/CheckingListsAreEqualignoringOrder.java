package com.ragul.demo.problems.Collections;

import java.util.HashSet;
import java.util.List;

public class CheckingListsAreEqualignoringOrder {
    public static void main(String[] args) {
        // Example lists
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(5, 4, 3, 2, 1);

        // Check if lists are equal ignoring order
        boolean areEqual = new HashSet<>(list1).equals(new HashSet<>(list2));

        System.out.println("Are the lists equal ignoring order? " + areEqual);
    }
}
