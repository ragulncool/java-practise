package com.ragul.demo.problems.slidingwindowalgorithm.variablesizewindow;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

//neat explanation
//https://www.youtube.com/watch?v=sQJ2KH1CWg4
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        String[] s={"abcabcbb"};//,"bbbbb","pwwkew","dvdf","aab","abcabcbb","abba","abccba"};
        for (String str : s) {
            System.out.println("Input: " + str+" "+brutalApproach(str)+" "+slidingWindowApproach(str));
        }
    }


    private static int brutalApproach(String s) {
        int maxlength = 0;

        for (int i=0;i<s.length();i++) {
            boolean[] visited = new boolean[256]; //we can use Set<Char> visited = new HashSet<>(); //but this is more efficient visited.add(c) or remove(c)
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

   // abcabc
    //1st windoe which doesnt contain non-repeating characters
    //start =0 =a
    //end =2 = c

    private static int slidingWindowApproach(String s) {
        int maxLen = 0, windowLen = 0;

        int start=0, end=0;
        //boolean[] visited = new boolean[256];
        Set<Character> visited = new HashSet<>();

        while (end<s.length()){
            char startC = s.charAt(start);
            char endC = s.charAt(end);

            //If element already visited
            while (visited.contains(endC)) {
                visited.remove(startC);

                start++;
                startC = s.charAt(start); //done to refresh else use s.charAt directly without using leftC or rightC
            }
            System.out.println("start: " + start + ", end: " + end + ", startC: " + startC + ", endC: " + endC+ "   LENGTH: " + (end - start + 1));
            maxLen=Math.max(end-start+1,maxLen);
            visited.add(endC);//visited[endC] = true;

            end++;
        }
        return maxLen;
    }

}
