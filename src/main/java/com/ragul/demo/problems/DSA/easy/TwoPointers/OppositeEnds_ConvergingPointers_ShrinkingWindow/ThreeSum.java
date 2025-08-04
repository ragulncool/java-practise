package com.ragul.demo.problems.DSA.easy.TwoPointers.OppositeEnds_ConvergingPointers_ShrinkingWindow;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[][] nums= new int[][]{{-1,0,1,2,-1,-4},{0,1,1},{0,0,0},{-2, -2, 0, 0, 2, 2}};
        int[] target = {0,0,0,0};

        for (int i=0;i<nums.length;i++){
            System.out.println("====================");
            Arrays.sort(nums[i]);
            System.out.println(find3Sum(nums[i],target[i]));
        }
    }

    //Time Complexity: O(N^2) - Two Pointer, Space Complexity: O(N)

    //since we eleminates duplicates using set in final string, we can also eliminate before itself for i, left and right - commented those code
    private static Set<List<Integer>> find3Sum(int[] num, int target) {
        Set<List<Integer>> set = new HashSet<>(); //REMOVES DUPLICATES in final result


        for (int i=0;i<num.length;i++){

            //duplicate check in i
//            if (i > 0 && num[i] == num[i - 1]){
//                System.out.println("Skipping duplicate for i: " + num[i]);
//                continue; // Skip duplicates for i
//            }

            int left = i+1;
            int right = num.length-1;

            while (left<right){
                //duplicate check in left and right
//                if (left > i + 1 && num[left] == num[left - 1]) {
//                    System.out.println("Skipping duplicate for left: " + num[left]);
//                    left++; // Skip duplicates for left
//                    continue;
//                }
//                if (right < num.length - 1 && num[right] == num[right + 1]) {
//                    System.out.println("Skipping duplicate for right: " + num[right]);
//                    right--; // Skip duplicates for right
//                    continue;
//                }


                int sum = num[i]+num[left]+num[right];

                if (sum==target){ //sum==0
                    List<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    set.add(list);


                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Move left pointer to increase sum
                }else{
                    right--; // Move right pointer to decrease sum
                }
            }


        }
        return set;
    }
}
