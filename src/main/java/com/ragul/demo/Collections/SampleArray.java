package com.ragul.demo.Collections;

import java.util.Arrays;
import java.util.List;


//Array is a collection of elements of the same type, stored in sequential and contiguous memory locations.
//It is a fixed-size data structure that allows for efficient access and manipulation of elements.
//Arrays in Java are zero-indexed, meaning the first element is at index 0.
//Arrays can be of primitive types (like int, char, etc.) or reference types (like String, Object, etc.).
//Common operations on arrays include accessing elements, iterating through elements, sorting, searching, and filling.
//Arrays are not dynamic, meaning their size cannot be changed after creation.
//Java provides the Arrays class in the java.util package, which contains various utility methods for array manipulation.
//The Arrays class provides methods for sorting, searching, comparing, filling, and converting arrays to strings.
//The Arrays class also provides methods for comparing arrays, checking equality, and performing binary searches.
//Arrays can be multidimensional, allowing for the creation of matrices or tables.
//Arrays can be converted to lists using the Arrays.asList() method, which returns a fixed-size list backed by the array.
//The Arrays class provides methods for converting arrays to strings, which is useful for debugging and displaying array contents.
//The Arrays class provides methods for comparing arrays, checking equality, and performing binary searches.

//[ 1 2 3 4 5 6 7 8 9 ]
//memory address example of index 0 is 2000
//next index 1 is 2004 (int is 4 bytes in Java)

public class SampleArray {
    public static void main(String args[]){

        // declare an array
        int[] data;

        // allocate memory
        data = new int[10];

        //declare and initialize and array
        int[] arr = {12, 4, 5, 2, 5};
        char c[]= { 'd','b','c' };
        char d[]= { 'd','b','c' };

        //MOST USED
        System.out.println(c[0]);
        System.out.println(c.length); //list.size()
        Arrays.sort(c);      System.out.println(c);//affects original array
        System.out.println(Arrays.equals(c,d));
        List<Integer> a = Arrays.asList();

        //LEAST USED
        System.out.println(Arrays.compare(c,d));
        Arrays.fill(d,'e');         System.out.println(d); //fill all indexes with the element
        System.out.println(Arrays.binarySearch(c,'a'));

         String s = Arrays.toString(c);
       //while plain charArray.toString prints hashcode - wrong

        // Add element - list.addAll(oldlist)
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = 6;

         // Remove element at index 2
        int[] removedArr = new int[arr.length - 1];



        //CLEAR ARRAY   list1.clear();
        Arrays.fill(arr, 0);

        //COPYING ARRAY
//        1. Arrays.copyOf: Allocates new array, copies elements, returns new array.
//        2. System.arraycopy: Copies elements between existing arrays, no allocation.

        //subarray list.subList(1,2)); //start index, endindex-1
        int[] subArray = Arrays.copyOfRange(arr, 1, 3); //from index 1 to index 2 (end index is exclusive)
        System.out.println(Arrays.toString(subArray)); //prints [4, 5]

        int[] newa = Arrays.copyOf(arr, arr.length+5);

        System.arraycopy(arr, 0, removedArr, 0, 2);
        System.arraycopy(arr, 3, removedArr, 2, arr.length - 3);



//        List<String> list = Arrays.asList("a", "b", "c");
//        int lastIndex = list.size() - 1; // returns 2 for this example
//        System.out.println(lastIndex);


        //NO BELOW METHODS IN ARRAY
        //CONTAIN list.contains("A")

    }

    public int[] returnArrayFromMethod(){
        return new int[]{1,2,3};//returning array
    }

    //JVM throws ArrayIndexOutOfBoundsException to indicate that the array has been accessed with an illegal index.
}
