package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

public class LongestRepeatingCharacterReplacement {
    //same as longest substring with atmost k distinct characters

    //correct o/p but wrong logic. change
    public static void main(String[] args) {
        String[] s = {"AABABBA","ABAB","AABBA", "AABBAA", "AAABBB"};
        int k[] = {1,2,1, 2, 1};
        for (int i=0; i < s.length; i++) {
            System.out.println("Input: s = \"" + s[i] + "\", k = " + k[i]);
            System.out.println("Output: " + findLongestRepeatingCharacterReplacement(s[i], k[i]));
        }
    }

    private static int findLongestRepeatingCharacterReplacement(String s, int k) {
        int maxCount = 0, start = 0, end=0, maxLength = 0, count=0;

        while (end < s.length()) {
            if(s.charAt(end) != 'A')count++;//charCount[s.charAt(end) - 'A']++;
           // maxCount = Math.max(maxCount, charCount[s.charAt(end) - 'A']);

            // If the current window size minus the count of the most frequent character is greater than k,
            // we need to shrink the window from the left.
//            if (end - start + 1 - maxCount > k) {
//                charCount[s.charAt(start) - 'A']--;
//                start++;
//            }
            while (count>k){
                if(s.charAt(start) != 'A')count--;//charCount[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}
