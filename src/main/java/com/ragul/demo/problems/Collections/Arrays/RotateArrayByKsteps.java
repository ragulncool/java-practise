package com.ragul.demo.problems.Collections.Arrays;

import java.util.Arrays;

public class RotateArrayByKsteps {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("======");
        rotateArrayByKsteps(nums, 3);
        System.out.println("======");
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArrayByKsteps(nums, 7);
        System.out.println("======");
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArrayByKsteps(nums, 8);
    }

    //Time complexity  K x N
    private static void rotateArrayByKsteps(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than n
        if (k == 0) return; // No rotation needed

        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        System.out.println("Array after rotation: " + Arrays.toString(nums));
    }


}
