package com.ragul.demo.problems.TwoPointers;

import java.util.Arrays;

public class ReturnTwoIndicesWithGivenSum {
    public static void main(String[] args) {

        int[] arr = {6,2,8,4,1}; //condition: arr should sorted in asc
        int target = 10;
        findIndicesWithGivenSumUsingTwoPointer(arr, target); //O(n) Time complexity, O(1) space complexity
        findIndicesWithGivenSumUsingBruteForce(arr, target); //O(n^2) Time complexity, O(1) space complexity
    }

    private static int[] findIndicesWithGivenSumUsingTwoPointer(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("TWO POINTER APPROACH "+left+" "+right);
                return new int[]{left, right}; // Return the indices of the two numbers
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{}; // Return an empty array if no such indices are found
    }

    //brute force approach
    private static int[] findIndicesWithGivenSumUsingBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(i+" "+j);
                    return new int[]{i, j}; // Return the indices of the two numbers
                }
            }
        }
        return new int[]{}; // Return an empty array if no such indices are found
    }
}
