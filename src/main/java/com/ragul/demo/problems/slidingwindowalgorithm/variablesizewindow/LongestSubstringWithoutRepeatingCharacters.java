package com.ragul.demo.problems.slidingwindowalgorithm.variablesizewindow;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

//Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        String[] s={"abcabcbb","bbbbb","pwwkew","dvdf","aab","abcabcbb","abba","abccba"};
        for (String str : s) {
            System.out.println("Input: " + str+" "+brutalApproach(str)+" "+slidingWindowApproach(str));
        }
    }


    private static int brutalApproach(String s) {
        int maxlength = 0;

        for (int i=0;i<s.length();i++) {
            boolean[] visited = new boolean[256];
           //int windowlen = 0; //commented code are my logic

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (visited[c]) {
                    break;
                } else {
                  // windowlen++;  maxlength=Math.max(windowlen,maxlength); //commented code are my logic
                    maxlength = Math.max(j-i+1, maxlength); //NOTE: for single char, it will be 1
                    visited[c] = true;
                }
            }
        }
        return maxlength;
    }

    private static int slidingWindowApproach(String s) {
        int maxLen = 0, windowLen = 0;

        int left=0, right =0;
        boolean[] visited = new boolean[256];

        while (right<s.length()){
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);

            while (visited[rightC]) {
//                maxLen=Math.max(windowLen,maxLen); //my commented logic not working
//                windowLen=0;
                visited[leftC] = false;
                left++;
                leftC = s.charAt(left); //done to refresh else use s.charAt directly without using leftC or rightC
            }
           // windowLen++;
            maxLen=Math.max(right-left+1,maxLen);
            visited[rightC] = true;
            right++;
        }
        return maxLen;
    }

}
