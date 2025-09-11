package com.ragul.demo.problems.Collections.BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Integer[] nums = {1, 3, 3, 3,  5, 7, 9};
        Integer[] targets = {3};
        for (Integer target : targets) {
            System.out.println("Target: " + target);
//        System.out.println("LINEAR SEARCH              : " + findLinearSearch(nums, target));
            System.out.println("BINARY SEARCH - LOWER BOUND TECHNIQUE: " + findUsingLowerBoundTechnique(nums, target));
            System.out.println("BINARY SEARCH - UPPER BOUND TECHNIQUE: " + findUsingUpperBoundTechnique(nums, target));

        }

    }
    //lower bound - till mid
    //upper bound - from mid+1

    private static int findUsingUpperBoundTechnique(Integer[] nums, Integer target) {
        int low = 0, high = nums.length - 1;

        while (low<high){
            int mid = (low+high)/2;

            if(target<nums[mid]){
                high = mid;
            } else{
                low = mid +1;
            }
        }
        return low;
    }

    private static int findUsingLowerBoundTechnique(Integer[] nums, Integer target) {
        int low = 0, high = nums.length - 1;

        while (low<high){
            int mid = (low+high)/2;

            if(target<=nums[mid]){
                high = mid;
            } else{
                low = mid +1;
            }
        }
        return low;
    }
}
