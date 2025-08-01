package com.ragul.demo.problems.DSA.easy.PriorityQueueOrHeap.MaxSubArraySumCircular;

public class MaxSubArraySumCircular {
    public static void main(String[] args) {
        MaxSubArraySumCircular sol = new MaxSubArraySumCircular();

        System.out.println("Example 1: " + sol.maxSubarraySumCircular(new int[]{1, -2, 3, -2})); // Expected: 3
        System.out.println("Example 2: " + sol.maxSubarraySumCircular(new int[]{5, -3, 5})); // Expected: 10
        System.out.println("Example 3: " + sol.maxSubarraySumCircular(new int[]{-3, -2, -3})); // Expected: -2
        System.out.println("Example 3: " + sol.maxSubarraySumCircularBrutal(new int[]{-3, -2, -3})); // Expected: -2

    }
//Time Complexity: O(N^2) - Brutal Force, Space Complexity: O(1)
    private int maxSubarraySumCircularBrutal(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        for (int i=0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length + i; j++) {
                int index = (i+j) % nums.length; // to handle circular nature
                currentSum = currentSum + nums[index];
                System.out.println("Current Sum: " + currentSum);
            }
            globalMax = Math.max(globalMax, currentSum);
        }
        return globalMax;
    }

    private int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], currentMax = nums[0];
        int globalMin = nums[0], currentMin = nums[0];

        int totalSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            totalSum = totalSum + nums[i];

            // Calculate maximum subarray sum using Kadane's algorithm
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);

            // Calculate minimum subarray sum using Kadane's algorithm
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            globalMin = Math.min(globalMin, currentMin);
        }

        if (globalMax < 0){ //because totalSum - globalMin will be negative if all numbers are negative
            // If all numbers are negative, return the maximum subarray sum
            return globalMax;
        } else {
            // Return the maximum of the two cases: non-circular and circular
            return Math.max(globalMax, totalSum - globalMin);
        }

    }
}
