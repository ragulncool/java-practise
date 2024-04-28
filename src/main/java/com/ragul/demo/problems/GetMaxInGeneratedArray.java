package com.ragul.demo.problems;


//You are given an integer n. A 0-indexed integer array nums of length n + 1 is generated in the following way:
//
//        nums[0] = 0
//        nums[1] = 1
//        nums[2 * i] = nums[i] when 2 <= 2 * i <= n
//        nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
//        Return the maximum integer in the array
public class GetMaxInGeneratedArray {
    public static void main(String args[]) {
              int n=7;
            int newN = n+1;
            int[] nums = new int[newN];
            int max=1;
            nums[0]=0;
            nums[1]=1;
            for(int i=1;i<newN/2;i++){
                nums[2*i]=nums[i];
                max = max>nums[2*i]?max:nums[2*i];


                nums[(2*i)+1]=nums[i]+nums[i+1];
                max = max>nums[(2*i)+1]?max:nums[(2*i)+1];


            }
            for(int d:nums){
                System.out.println(d);
            }
        System.out.println(" max is: "+max);

    }
}