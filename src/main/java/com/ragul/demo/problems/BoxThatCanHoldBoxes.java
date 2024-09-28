package com.ragul.demo.problems;

//Number of visible boxes after putting one inside another
//Given N boxes and their size in an array. You are allowed to keep a box inside another box only if
// 1. the box in which it is held is empty
// 2. and the size of the box is at least twice as large as the size of the box. The task is to find minimum number of visible boxes.

//https://www.geeksforgeeks.org/number-visible-boxes-putting-one-inside-another/

import java.util.Arrays;

//Input : arr[] = { 1, 3, 4, 5 }
//        Output : 3
//        Put box of size 1 in box of size 3.
//
//        Input : arr[] = { 4, 2, 1, 8 }
//        Output : 1
//        Put box of size 1 in box of size 2
//        and box of size 2 in box of size 4.
//        And put box of size 4 in box of size 8.
public class BoxThatCanHoldBoxes {
    public static void main(String args[]){
        int[] nums={1,3,4,5};//{1,8,4,2};
        System.out.println(minBoxes(nums));
    }

    private static int minBoxes(int[] nums) {
        Arrays.sort(nums);
        int minBoxes=0;
        //own logic - have to check
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(2*nums[i]<=nums[j]){
//                    if(minBoxes==0) minBoxes=1;
//                    System.out.println(nums[i]+" x 2 is <= "+nums[j]+" minBoxes: "+minBoxes);
//                }else{
//                    minBoxes++;
//                    System.out.println(nums[i]+" x 2 is > "+nums[j]+" minBoxes: "+minBoxes);
//                }
//            }
//        }

        return minBoxes;
    }
}
