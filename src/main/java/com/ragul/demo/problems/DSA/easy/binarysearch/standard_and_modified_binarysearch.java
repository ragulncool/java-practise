package com.ragul.demo.problems.DSA.easy.binarysearch;

import static java.util.Arrays.binarySearch;

public class standard_and_modified_binarysearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 4, 8, 9, 10};
        int target = 11;
        System.out.println(standardBinarySearch(arr, target));
        System.out.println(modifiedBinarySearch(arr, target));

        int target1 = 4;
        System.out.println(standardBinarySearch(arr, target1));
        System.out.println(modifiedBinarySearch(arr, target1));

        int target2 = 10;
        System.out.println(standardBinarySearch(arr, target2));
        System.out.println(modifiedBinarySearch(arr, target2));

    }

    private static int standardBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start+end)/2;// start + (end - start) / 2; // This avoids overflow compared to (start + end) / 2

            if (arr[mid] == target) {
                return mid; // Target found, return its index //IF START=END, THEN MID=START FROM MID FORMULA;
            } else if (arr[mid] < target) {
                start = mid + 1; // Move to the right half
            } else {
                end = mid - 1; // Move to the left half
            }
        }

        return -1; //not found, return -1
    }

    //not clear
    private static int modifiedBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start+end)/2; //start + (end - start) / 2; // This avoids overflow compared to (start + end) / 2

            if (arr[mid] == target) {
                return mid; // Target found, return its index
            } else if (arr[mid] < target) {
                start = mid + 1; // Move to the right half
            } else {
                end = mid - 1; // Move to the left half
            }
        }

        return start;// If target is not found, return the position where it can be inserted
    }
}
