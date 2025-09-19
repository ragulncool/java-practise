package com.ragul.demo.problems.DSA.easy.PrefixSum;


//Time Complexity
//Building prefix sum: O(n)
//Querying sum in range: O(1)

//Space Complexity: O(n)
public class Basics {
    public static void main(String[] args) {
        int[] nums= {1,2,3};

        int[] prefixSum = new int[nums.length];

        prefixSum[0]=nums[0];

        for (int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        //betweel 2 andd 4
        int l=2, r=4;
        System.out.println(prefixSum[r] - prefixSum[l-1]);

    }
}
