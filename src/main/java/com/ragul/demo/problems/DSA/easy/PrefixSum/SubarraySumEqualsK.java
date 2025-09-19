package com.ragul.demo.problems.DSA.easy.PrefixSum;

import java.util.HashMap;
import java.util.Map;

class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        System.out.println(subarraySum(nums,3));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();

        // Initialize with a prefix sum of 0 occurring once, to handle subarrays starting from index 0
        prefixSumCounts.put(0, 1);

        for (int num : nums) {
            currentSum = currentSum + num;

            // Update the frequency of the current prefix sum
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);

            // If (currentSum - k) exists in the map, it means there's a prefix sum
            // that, when subtracted from currentSum, results in k.
            // The number of such prefixes determines the number of subarrays ending here with sum k.
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count = count + prefixSumCounts.get(currentSum - k);
            }


        }

        return count;
    }
}
