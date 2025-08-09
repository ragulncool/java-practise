package com.ragul.demo.problems.Collections.String;

//You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
//
//A substring is a contiguous sequence of characters within a string.
//
//        Example 1:
//
//Input: num = "52"
//Output: "5"
//Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
//        Example 2:
//
//Input: num = "4206"
//Output: ""
//Explanation: There are no odd numbers in "4206".
//Example 3:
//
//Input: num = "35427"
//Output: "35427"
//Explanation: "35427" is already an odd number.
public class LargestOddNumberInString {
    public static void main(String[] args) {
        String[] nums={"52","4206","35427"};
        for (int i=0;i<nums.length;i++){
            System.out.println(find(nums[i]));
        }
    }

    private static String find(String nums) {
        int start=nums.length()-1;
        while(start>=0){
            if(nums.charAt(start)%2!=0){
                return nums.substring(0,start+1);
            }
            start--;
        }
        return "";
    }
}
