package com.ragul.demo.problems.DSA.easy.TwoPointers;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s.toCharArray(), t.toCharArray())); // Output: true

        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence(s.toCharArray(), t.toCharArray())); // Output: false
    }

    private static boolean isSubsequenceCopilot(char[] charArray, char[] charArray1) {
        if (charArray.length > charArray1.length) {
            return false; // If s is longer than t, it can't be a subsequence
        }

        int sIndex = 0, tIndex = 0;

        while (sIndex < charArray.length && tIndex < charArray1.length) {
            if (charArray[sIndex] == charArray1[tIndex]) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == charArray.length; // If we reached the end of s, it's a subsequence
    }

    private static boolean isSubsequence(char[] s, char[] t) {
        int sIndex = 0, tIndex = 0;

        while (sIndex<s.length && tIndex<t.length) {
            if(s[sIndex]== t[tIndex]) {
                sIndex++;
                tIndex++;
            }else{
                tIndex++;
            }
        }
        return s[sIndex-1]== t[tIndex-1];
    }
}
