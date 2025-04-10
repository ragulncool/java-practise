package com.ragul.demo.Collections.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayAndCollectionsSorting {
    public static void main(String[] args) {

        //arrays sort
        int[] numbers = {5, 3, 8, 2, 1};
        System.out.println("Original array: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        char[] characters = {'o', 'i', 'e', 'u', 'a'}; //Character[] change to primitive typemfor using Collections.reverseOrder
        System.out.println("Original array: " + Arrays.toString(characters));

        Arrays.sort(characters);
        System.out.println("ASC Sorted array: " + Arrays.toString(characters));

        // Arrays.sort(characters, Collections.reverseOrder()); -> COllections.reverseorder will work only for Primitive. hence chanhe chaar[] to CHaracter[]
        System.out.println("DESC Sorted array: " + Arrays.toString(characters));

//desc

        //collections sort
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("banana");
        wordsList.add("apple");
        wordsList.add("cherry");
        wordsList.add("date");
        System.out.println("Original list: " + wordsList);

        Collections.sort(wordsList);
        System.out.println("ASC Sorted list: " + wordsList);

        Collections.sort(wordsList, Comparator.reverseOrder()); //ANY OF THESE 2
        Collections.reverse(wordsList);
//        wordsList.stream().sorted().toList();
//        wordsList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("DES Sorted list: " + wordsList);

        Collections.shuffle(wordsList);
        System.out.println("SHUFFLE list: " + wordsList); //random

    }
}

    //LIMITATION

    //Java’s built-in sorting methods, such as Arrays.sort() and Collections.sort(),
    // are powerful and efficient for sorting primitive types and objects with natural ordering (like String),
    // they fall short when it comes to sort