package com.ragul.demo.problems.DSA.easy.TwoPointers;



public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s)); // Output: "bab" or "aba"

        s = "cbbd";
        System.out.println(longestPalindrome(s)); // Output: "bb"
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0, maxLength=0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindrome
            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2; //CENTER of the palindrome-LENTH/2
               // end = i + len / 2;
            }
        }

        return s.substring(start, start + maxLength);
      //  return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome // the actual length is (right - 1) - (left + 1) + 1 = right - left - 1.
    }
}