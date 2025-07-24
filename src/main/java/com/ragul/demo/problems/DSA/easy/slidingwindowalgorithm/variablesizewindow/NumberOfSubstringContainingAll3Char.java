package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

import java.util.HashMap;
import java.util.Map;


public class NumberOfSubstringContainingAll3Char {
    //count of substrings containing all 3 characters in a string at end = nums.length-end
  //bbacba
   // at b as end= 6-4 =2 (bac, bbac) - expand window at front
    public static void main(String[] args) {
        String[] nums = {"abcabc","aaacb","abc","bbacba"};
        for(int i=0;i<nums.length;i++){
            System.out.println("========="+nums[i]);
            System.out.println( findNumberOfSubstringContainingAll3Char(nums[i]));
        }
    }

    private static int findNumberOfSubstringContainingAll3Char(String num) {
        int start=0, end=0, count=0;
        Map<Character,Integer> map=new HashMap<>();

        while (end<num.length()){
            char startC = num.charAt(start);
            char endC = num.charAt(end);

            map.put(endC,map.getOrDefault(endC,0)+1);

            //GIVEN ARRAY WILL ALWAYS CONTAIN 3 DISTINCT CHARACTERS. SO NO NEED OF >3

            while (map.size()==3){
                count += (num.length() - end);
                System.out.println(count + " : " + num.substring(start, end + 1) + " [" + start + " to " + end + "]");
                //example: abcabc, start=0, end=2, count=6 (abc, abca, abcab, abcabc) 6-2=4
                //startz

                map.put(startC, map.get(startC)-1);
                if(map.get(startC)==0){
                    map.remove(startC);
                }
                start++;
            }

//            if(map.size()==3){
//                count += end - start + 1; //all substrings starting from start to end are valid
//                System.out.print(start+"["+startC+"] to "+end+"["+endC+"] ");
//            }
            end++;
        }
        return count;
    }
}
