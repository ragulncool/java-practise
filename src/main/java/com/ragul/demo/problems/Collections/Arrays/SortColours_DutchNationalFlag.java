package com.ragul.demo.problems.Collections.Arrays;


//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.


//Example 1:
//
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Example 2:
//
//Input: nums = [2,0,1]
//Output: [0,1,2]

//Time O(n), space O(1)
public class SortColours_DutchNationalFlag {
    public static void main(String[] args) {
        int [][] nums={{2,0,2,1,1,0},{2,0,1}};
        for (int i=0;i<nums.length;i++){
            int[] num = sortNums(nums[i]);

            for (int j=0;j<num.length;j++){
                System.out.print(num[j]+" ");
            }
            System.out.println();
        }
    }

    private static int[] sortNums(int[] num) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for (int i=0;i<num.length;i++){
          if (num[i] ==0) count_0++;
          else if (num[i] ==1) count_1++;
          else if (num[i] ==2) count_2++;
        }

        int index=0;
        while (count_0-- >0) num[index++]=0;
        while (count_1-- >0) num[index++]=1;
        while (count_2-- >0) num[index++]=2;

//        while (count_0>0)
//        {
//            num[index]=0;
//            count_0--;
//            index++;
//        }
        return num;
    }
}
