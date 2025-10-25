package com.ragul.demo.problems.DSA.medium.BinarySearch_O_logN;

public class BinarySearchGenericVersion {
    public static void main(String[] args) {
        // Example with Integers
        Integer[] nums = {1, 3, 5, 7, 9};
        Integer[] targets = {1, 3, 5, 7, 9, 6};

        for (Integer target : targets) {
            System.out.println("Target: " + target);
            System.out.println("LINEAR SEARCH              : " + findLinearSearch(nums, target));
            System.out.println("BINARY SEARCH (WHILE LOOP) : " + findBinarySearchUsingLoop(nums, target));
            System.out.println("BINARY SEARCH (RECURSION)  : " + findBinarySearchUsingRecursion(nums, target, 0, nums.length - 1));
            System.out.println("-----------------------------------");
        }

        // Example with Strings
        String[] words = {"apple", "banana", "cherry", "date", "fig"};
        String targetWord = "cherry";
        System.out.println("Target: " + targetWord);
        System.out.println("LINEAR SEARCH (Strings)    : " + findLinearSearch(words, targetWord));
        System.out.println("BINARY SEARCH (Strings)    : " + findBinarySearchUsingLoop(words, targetWord));
    }

    // Recursive Binary Search (Generic)
    private static <T extends Comparable<T>> int findBinarySearchUsingRecursion(T[] arr, T target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) > 0) {
                return findBinarySearchUsingRecursion(arr, target, low, mid - 1);
            } else {
                return findBinarySearchUsingRecursion(arr, target, mid + 1, high);
            }
        }
        return -1;
    }

    // Iterative Binary Search (Generic)
    private static <T extends Comparable<T>> int findBinarySearchUsingLoop(T[] arr, T target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Linear Search (Generic)
    private static <T> int findLinearSearch(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
