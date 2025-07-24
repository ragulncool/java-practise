package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

public class MaximumConsecutiveOnesIII {
    //longest substring with atmost k zeros
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1,1,0,0,0,1,1,1,1,0},{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}};
        int[] k={2,3};
        for (int i=0;i<nums.length;i++){
            System.out.println("BF: "+findByBF(nums[i],k[i]));
            System.out.println("Sliding Window: "+findBySW(nums[i],k[i]));
        }

    }

    private static int findBySW(int[] num, int k) {
        int start=0, end=0, maxLen=0, zeros=0;
        while (end<num.length){
            if (num[end]==0)  zeros++;

            while (zeros>k){ //replace by if for optimal apparoach. no need to shrink further since they will be lowest length
                if (num[start]==0)  zeros--;
                start++;
            }
            maxLen = Math.max(maxLen,end-start+1);
            end++;
        }
        return maxLen;
    }

    private static int findByBF(int[] num, int k) {
        int maxLen=0;
        for (int i=0;i<num.length;i++){
            int zeros=0;
            for (int j=i; j<num.length;j++){
                if(zeros>k){
                    break;
                }
               if (num[j]==0)  zeros++;
               if (zeros<=k){
                   maxLen = Math.max(maxLen,j-i+1);
               }
            }
        }
        return maxLen;
    }
}
