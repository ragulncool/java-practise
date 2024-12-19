package com.ragul.demo.Collections;
//Input:
//        S = "geeksforgeeks"
//        Output: 7
//        Explanation: "eksforg" is the longest
//        substring with all distinct characters.
//        Example 2:
//
//        Input:
//        S = "aaa"
//        Output: 1
//        Explanation: "a" is the longest substring
//        with all distinct characters

//DIDNT COMPLETE
public class LongestDistinctCharacterInAString {
    public static void main(String args[]) {
      String str = "aaa";
      System.out.println(longestDistinctChar(str));
    }

    private static boolean longestDistinctChar(String str) {
        char[] chars= str.toCharArray();
        StringBuilder common = new StringBuilder();
        for(int i=0;i<str.length();i++){
            common.append(chars[i]);
        }
        return false;
    }
}
