package com.ragul.demo.problems.Collections.HashMap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[][] nums={{200,4,100,1,3,2},{0,3,7,2,5,8,4,6,0,1},{1,0,1,2}};
        for(int i= 0;i<nums.length;i++){
            System.out.println(findLCS(nums[i]));
        }
    }

//T - O(n), S- O(n)
    private static int findLCS(int[] nums) {
        int maxlcscount=0;
        Set<Integer> set = new HashSet<>();

        //add all ements to set
        for(int num: nums){
            set.add(num);
        }

        for(int num: set){ //iterating set since duplicates
             if(!set.contains(num-1)){
                 System.out.println("Iterating "+num);
                 int windowLcsCount =1;
                 num=num+1;

                 while(set.contains(num)){
                     windowLcsCount++;
                     num++;
                 }
                 maxlcscount = Math.max(maxlcscount,windowLcsCount);
             }
        }
        return maxlcscount;
    }
}
