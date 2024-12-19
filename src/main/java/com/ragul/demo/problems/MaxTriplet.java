package com.ragul.demo.problems;

import java.util.Arrays;

//Given an integer array, find a maximum product of a triplet in the array.
//
//        Examples:
//
//        Input:  [10, 3, 5, 6, 20]
//        Output: 1200
public class MaxTriplet {
    public static void main(String args[]){
        int[] nums={10,3,5,6,20};

        //-ve
        if(nums.length<3){
            System.out.println("triplet cannot be formed");
            return;
        }

        int maxProduct=0;
        for(int i=0;i<=nums.length-3;i++){
            for(int j=i+1;j<=nums.length-2;j++){
                for(int k=j+1;k<=nums.length-1;k++){
                    int product = nums[i]*nums[j]*nums[k];
                    if(product>maxProduct){
                        maxProduct=product;
                    }
                }
            }
        }
        System.out.println(maxProduct);

        //APPROACH 2
        Arrays.sort(nums);
        System.out.println(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}
