package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.fixedsizewindow;

public class MaxSumOfAllSubArrays_SubArraySizeKGiven {
    public static void main(String args[]) {
        int[] nums= {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k=3; //subarray size
        System.out.println(brutalApproach(nums,k)); //O(n*k) Time complexity
       System.out.println(slidingWindowApproach(nums,k)); //O(n)
    }

    // O(n k) Time and O(1) Space
    private static int brutalApproach(int[] nums, int k) {
        int maxSum = 0;

        for(int i=0;i<nums.length-k+1;i++){
            int winSum=0;
            for(int j=0;j<k;j++){
                winSum = winSum + nums[i+j];
            }

//            for(int j=i;j<=i+2;j++){
//                winSum = winSum + nums[j];
//                //System.out.println("i:"+i+"     j:"+j+"     winsum:"+winSum);
//            }
            maxSum=Math.max(maxSum,winSum);
        }

        return maxSum;
    }

    // O(n) Time and O(1) Space
    private static int slidingWindowApproach(int[] nums, int k) {
        int maxSum = 0;
        int windowSum=0;

        //first window
        for(int i=0;i<k;i++){
            windowSum=windowSum+nums[i];
        }
        maxSum=windowSum;



//        //remaining  - WRONG IN MULTIPLE SITES - window index 1,2,3 and 2,3,4 are ignored
//        for(int i=k;i<=nums.length-k+1;i++){
//            windowSum = windowSum + nums[i]-nums[i-k]; //remove last element from last window and add first element from new window
//            maxSum=Math.max(maxSum,windowSum);
//        }

        //remaining windows
        for(int i=1;i<nums.length-k+1;i++){
            windowSum = windowSum + nums[i-1+k]-nums[i-1]; //remove last element from last window and add first element from new window
            maxSum=Math.max(maxSum,windowSum);
        }

        return maxSum;
    }
}
