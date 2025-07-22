package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;



//Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
//
//Return the number of nice sub-arrays.
//
//        Example 1:
//
//Input: nums = [1,1,2,1,1], k = 3
//Output: 2
//Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
//Example 2:
//
//Input: nums = [2,4,6], k = 1
//Output: 0
//Explanation: There are no odd numbers in the array.
//Example 3:
//
//Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//Output: 16
public class CountNumberOfNiceSubarrays {
    //1. we can use the formula: exactly(k) = atMost(k) - atMost(k - 1).
    //k =   <=k   -   <=k-1

    //2. consider positive odd numbers as 1 and negative odd numbers as -1
    public static void main(String args[]){
            int[] nums = {1,1,2,1,1};
            int k=3;
            System.out.println(countNumberOfNiceSubarrays(nums,k));

        int[] nums1 = {2,4,6};
        int k1 =1;
        System.out.println(countNumberOfNiceSubarrays(nums1, k1));

        int[] nums2 = {2,2,2,1,2,2,1,2,2,2};
        int k2 =2;
        System.out.println(countNumberOfNiceSubarrays(nums2, k2));
    }



          private static int countNumberOfNiceSubarrays(int[] nums, int k) {
        //edge case
        if(k==0 || nums.length==0) return 0;

        //using the formula: exactly(k) = atMost(k) - atMost(k - 1)
        return countNumberOfNiceSubarraysAtmostK(nums,k) - countNumberOfNiceSubarraysAtmostK(nums,k-1);
    }

    private static int countNumberOfNiceSubarraysAtmostK(int[] nums, int k) {
            int sum=0,niceArrCount=0,start=0,end=0;


        while (end<nums.length){
            if(nums[end]%2!=0){
                sum=sum+1; //or sum=sum-1
            }
;
           while (sum>k){
               if(nums[start]%2!=0){
                   sum=sum-1; //or sum=sum-1
               }
               start++;
           }

               niceArrCount=niceArrCount + end-start+1; //using instead of count++ -   all subarrays starting from 'start' to 'end' are valid

            end++;
        }
        return niceArrCount;
    }
}
