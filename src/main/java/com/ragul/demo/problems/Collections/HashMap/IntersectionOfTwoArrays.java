package com.ragul.demo.problems.Collections.HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[][] nums1 = {{1,2,2,1},{4,9,5}};
        int[][] nums2= {{2,2},{9,4,9,8,4}};
        for(int i=0;i<nums1.length;i++){
            System.out.println(findIntersection1(nums1[i],nums2[i]));
        }

    }

    //Time O(m+n), Space (m+k) ,
//    m = length of nums1
//            n = length of nums2
//    k = number of unique elements in intersection
    public static Set<Integer> findIntersection1(int[] num1, int[] num2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for(int i=0;i<num1.length;i++){
            set.add(num1[i]);
        }
        for(int i=0;i<num2.length;i++){
           if(set.contains(num2[i])){
               intersection.add(num2[i]);
           }
        }

        return intersection;
    }
}
