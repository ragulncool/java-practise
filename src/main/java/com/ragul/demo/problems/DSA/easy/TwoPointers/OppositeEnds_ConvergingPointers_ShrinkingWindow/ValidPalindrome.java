package com.ragul.demo.problems.DSA.easy.TwoPointers.OppositeEnds_ConvergingPointers_ShrinkingWindow;

//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//        Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.

public class ValidPalindrome {
    public static void main(String[] args) {
        String[] s = {"A man, a plan, a canal: Panama","","malayala","race a car"};
        //^ means not, so this regex will remove all characters that are not preceding that
        System.out.println(s);
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].replaceAll("[^a-zA-Z0-9]", ""); // Remove non-alphanumeric characters
            System.out.println(checkValidPlaindrome(s[i]));
        }
    }

    private static boolean checkValidPlaindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}