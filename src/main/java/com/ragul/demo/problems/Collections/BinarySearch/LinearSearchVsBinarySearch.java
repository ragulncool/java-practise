package com.ragul.demo.problems.Collections.BinarySearch;

public class LinearSearchVsBinarySearch {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5,7,9};
        int[] target={1,3,5,7,9,6};
        for(int i=0;i<target.length;i++){
            System.out.println("LINEAR SEARCH : "+findLinearSearch(nums,target[i]));
            System.out.println("BINARY SEARCH USING WHILE LOOP: "+findBinarySearchUsingloop(nums,target[i]));
            System.out.println("BINARY SEARCH USING RECURSION: "+findBinarySearchUsingRecursion(0,nums.length-1,nums,target[i]));

        }

    }

    private static int findBinarySearchUsingRecursion(int low, int high, int[] nums, int target) {
        if(low<=high){
            int mid =(low+high) /2;
            if(nums[mid]==target){
                return mid;
            }else if (target<nums[mid]){
                high=mid-1;
                return findBinarySearchUsingRecursion(low,high,nums,target);
            }else{
                low=mid+1;
                return findBinarySearchUsingRecursion(low,high,nums,target);
            }
        }
        return -1;
    }

    //ALTERNATE - RECURSION POSITION
//    private static int findBinarySearchUsingRecursion(int low, int high, int[] nums, int target) {
//        if(low<=high){
//            int mid =(low+high) /2;
//            if(nums[mid]==target){
//                return mid;
//            }else if (target<nums[mid]){
//                high=mid-1;
//            }else{
//                low=mid+1;
//            }
//            return findBinarySearchUsingRecursion(low,high,nums,target);
//        }
//       return -1;
//    }

    private static int findBinarySearchUsingloop(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // not found
    }

    private static int findLinearSearch(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
