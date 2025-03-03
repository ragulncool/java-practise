package com.ragul.demo.Collections.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayAndCollectionsSorting {
    public static void main(String[] args) {

        //arrays sort
        int[] numbers = { 5, 3, 8, 2, 1 };
        System.out.println("Original array: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        char[] characters = { 'o', 'i', 'e', 'u', 'a' };
        System.out.println("Original array: " + Arrays.toString(characters));

        Arrays.sort(characters);
        System.out.println("Sorted array: " + Arrays.toString(characters));

        //collections sort
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("banana");
        wordsList.add("apple");
        wordsList.add("cherry");
        wordsList.add("date");
        System.out.println("Original list: " + wordsList);

        Collections.sort(wordsList);
        System.out.println("Sorted list: " + wordsList);
    }

    //LIMITATION

    //Java’s built-in sorting methods, such as Arrays.sort() and Collections.sort(),
    // are powerful and efficient for sorting primitive types and objects with natural ordering (like String),
    // they fall short when it comes to sorting custom objects.
    // These methods do not inherently know how to order user-defined objects because there is no natural way for them to compare these objects.
}