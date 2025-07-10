package com.ragul.demo.problems.Collections;

import java.util.List;

public class FirstNonRepeatedElementInList {
    public static void main(String[] args) {
        // Example list
        List<Integer> list = List.of(1, 2, 3, 2, 1, 4, 5, 4);

        // Find the first non-repeated element
        Integer firstNonRepeated = findFirstNonRepeatedElement(list);
        //or use map to get each count

        if (firstNonRepeated != null) {
            System.out.println("First non-repeated element: " + firstNonRepeated);
        } else {
            System.out.println("No non-repeated elements found.");
        }
    }

    private static Integer findFirstNonRepeatedElement(List<Integer> list) {
        for (Integer element : list) {
            if (list.indexOf(element) == list.lastIndexOf(element)) {
                return element; // Return the first non-repeated element
            }
        }
        return null; // Return null if no non-repeated element is found
    }
}
