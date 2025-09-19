package com.ragul.demo.problems.DSA.easy.PrefixSum;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums= {1,7,3,6,5,6};

        int[] prefixSum = new int[nums.length];

        prefixSum[0]=nums[0];

        for (int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        for (int i=0;i<nums.length;i++){
            int leftSum;
            if (i==0) leftSum=0;
            else leftSum = prefixSum[i-1];

            int rightSum = prefixSum[nums.length-1]-prefixSum[i];
            if (leftSum == rightSum){
                System.out.println(i);
            }
        }

    }
}
