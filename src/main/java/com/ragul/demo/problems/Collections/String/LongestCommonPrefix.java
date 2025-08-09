package com.ragul.demo.problems.Collections.String;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[][] s = {{"flower","flow","flight"},{"dog","racecar","car"},{"aab","aaba","aaaba"}};
        for (int i=0;i<s.length;i++){
            System.out.println(findLCP(s[i]));
        }
    }

    private static String findLCP(String[] s) {
        if(s.length==0) return "";
        String compWord = "";
        String commonPrefix="";

        for (int i=0;i<s.length;i++) {
//            compWord = s[0].substring(0,i+1);
            for (int j=1;j<s.length;j++) {
                if (s[j].substring(0,i+1).equals(s[0].substring(0,i+1))) {   //.equals(compWord
//                   if(j==s.length-1){
//                       commonPrefix=compWord;
//                   }
                }else{
                   return s[0].substring(0,i+1);// return commonPrefix;
                }
            }
        }
        return commonPrefix;
    }
}
