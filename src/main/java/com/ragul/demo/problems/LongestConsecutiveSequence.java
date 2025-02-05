package com.ragul.demo.problems;

//https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150

//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

import java.util.Arrays;

//Example 2:
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
public class LongestConsecutiveSequence {
    public static void main(String args[]) {
        Integer[] nums = {0,3,7,2,5,8,4,6,0,1};// {100,4,200,1,3,2};
        System.out.println("Length of  LongestConsecutiveSequence "+longestConsecutiveSequence(nums));
    }

    private static Integer longestConsecutiveSequence(Integer[] nums) {
        int length = 1;
        int maxLength=length;
        Arrays.sort(nums);

        if(nums.length==1){
            return 1;
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                length++;
            }else if(nums[i]-nums[i-1]!=0){ //else if sma evalue dont increment or reset length
                length=0;
            }

            if(length>maxLength){
                maxLength=length;
            }
        }
        return maxLength;
    }
}
