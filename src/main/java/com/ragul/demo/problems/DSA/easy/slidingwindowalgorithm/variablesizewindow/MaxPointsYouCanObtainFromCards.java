package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

public class MaxPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] nums= new int[]{1,2,3,4,5,6,1};
        int k=3;
        System.out.println(findMaxPointsFromCards(nums,k));

        int[] nums1= new int[]{2,2,2};
        int k1=2;
        System.out.println(findMaxPointsFromCards(nums1,k1));

        int[] nums2= new int[]{9,7,7,9,7,7,9};
        int k2=7;
        System.out.println(findMaxPointsFromCards(nums2,k2));
    }

    private static int findMaxPointsFromCards(int[] nums, int k) {
        int lsum=0, rsum=0, maxSum=0;

        for(int i=0; i<k;i++){
            lsum = lsum + nums[i];
        }
        maxSum=lsum;

        for(int i=k-1, j=nums.length-1;i>=0;i--,j--){
            lsum = lsum - nums[i];
            rsum = rsum + nums[j];
            maxSum=Math.max(maxSum,lsum+rsum);
        }

        return maxSum;
    }
}
