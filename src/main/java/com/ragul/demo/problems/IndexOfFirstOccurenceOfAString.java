package com.ragul.demo.problems;

// Input: haystack = "sadbutsad", needle = "sad"
//         Output: 0
//         Explanation: "sad" occurs at index 0 and 6.
//         The first occurrence is at index 0, so we return 0.
//
//         2. Input: haystack = "leetcode", needle = "leeto"
//         Output: -1
//         Explanation: "leeto" did not occur in "leetcode", so we return -1.
public class IndexOfFirstOccurenceOfAString {
    public static void main(String args[]) {
         String one = "a";
         String two = "a";
         System.out.println("Result: "+findIndexOfFirstOccurenceOfAString(one,two));
    }

    private static int findIndexOfFirstOccurenceOfAString(String parent, String child) {
        if(child.length() > parent.length()){
            return -1;
        }

        int subLength = child.length();
        int parLength = parent.length();
        for(int i=0;i<=parLength-subLength;i++){
            //System.out.println(i+" "+parent.substring(i,i+subLength));
            if(parent.substring(i,i+subLength).equals(child)){
                return i;
            }
        }
        return -1;
    }
}