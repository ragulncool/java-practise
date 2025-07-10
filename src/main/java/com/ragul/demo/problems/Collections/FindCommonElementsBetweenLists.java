package com.ragul.demo.problems.Collections;

import java.util.Arrays;
import java.util.List;

public class FindCommonElementsBetweenLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(4,5,6,7,8);


        // Using Java Streams to find common elements
        List<Integer> commonElements = list1.stream()
                .filter(list2::contains) // Filter elements that are present in list2
                .toList(); // Collect the results into a new List

        System.out.println("Common elements: " + commonElements);

        // Using a Set for better performance (especially for large lists)
        List<Integer> commonElementsSet = list1.stream()
                .filter(x -> list2.contains(x)) // Filter elements that are present in list2
                .distinct() // Ensure uniqueness
                .toList(); // Collect the results into a new List

        // Using retainAll method. //UnsupportedOperationException for immutable lists
//        list1.retainAll(list2); // Retain only the elements that are also in list2
//        System.out.println("Common elements (retainAll): " + list1);
    }
}
