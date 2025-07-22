package com.ragul.demo.problems.DSA.easy.binarysearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        System.out.println("Insert position for " + target + ": " + searchInsert(nums, target));

        target = 2;
        System.out.println("Insert position for " + target + ": " + searchInsert(nums, target));

        target = 7;
        System.out.println("Insert position for " + target + ": " + searchInsert(nums, target));

        target = 0;
        System.out.println("Insert position for " + target + ": " + searchInsert(nums, target));
    }

    private static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start+end) / 2; //alternative to (left + right) / 2 to avoid overflow

            if (nums[mid] == target) {
                return mid; // Target found, return its index
            } else if (nums[mid] < target) {
                start = mid + 1; // Move to the right half
            } else {
                end = mid - 1; // Move to the left half
            }
        }

        // If target is not found, return the position where it can be inserted
        return start;
    }
}
//mid = start + (end - start) / 2; // This avoids overflow compared to (start + end) / 2

// This is a common technique to find the middle index in binary search algorithms.

//start = 0, end = 3, mid = 1, nums[mid] = 3
//mid<target, so start = mid + 1 = 2

//break case
//start = 2, end = 3, mid = 2, nums[mid] = 5
//mid>target, so end = mid - 1 = 1
//start = 2, end = 1, start > end, so return start = 2
