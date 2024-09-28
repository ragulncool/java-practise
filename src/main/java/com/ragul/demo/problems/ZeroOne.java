package com.ragul.demo.problems;

import java.util.Arrays;
import java.util.Collections;

//{0,0,1,0,0,1};
//SHOULD STORE 0 IN LEFT AND 1 IN RIGHT
public class ZeroOne {
    public static void main(String args[]){
        int[] nums = {0,0,1,0,0,1};
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }

        //APPAROACH 2
        int[] sortedNums = new int[nums.length];
        int left=0;
        int right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sortedNums[left]=0;
                left++;
            }else{
                sortedNums[right]=1;
                right--;
            }
        }
        for(int i=0;i<sortedNums.length;i++){
            System.out.print(sortedNums[i]);
        }
    }
    }

