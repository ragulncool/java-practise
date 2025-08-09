package com.ragul.demo.problems.Collections.String.ExpandAroundCenter.PalindromicSubString;

//Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.
//
//        Example 1:
//
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//Example 2:
//
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//

//list all palindromes
//longest palindrome
import java.util.*;

public class PalindromicSubString_or_LongestPalindromeLength {
    static Map<String, Set<String>> allPalindromes = new HashMap<>();

    public static void main(String[] args) {
        String[] s = {"ababa","abc","aaa","ababac"}; //,
         for (int i=0;i<s.length;i++){
            //System.out.println(BF(s[i]));
//            System.out.println(longestPalindrome_EOC(s[0]));
        System.out.println("LONGEST PALINDROME SUBSTRING: " +longestPalindrome_EOC_oddEvenApproach(s[i]));
        System.out.println("ALL PALINDROMES :"+ allPalindromes.get(s[i]));
        }
    }


        public static String longestPalindrome_EOC_oddEvenApproach(String s) {
            if (s == null || s.length() < 1) return "";

            //for tracking longest palindrome
            int start=0,end=0;

            for (int i=0;i<s.length();i++){
                int oddLen = expandFromMiddle(s,i,i);
                int evenLen = expandFromMiddle(s,i,i+1);
                int len = Math.max(oddLen,evenLen);



                //len is lenght of palindrome centered at index i
                if(len>end-start){ //only longest or equal is tracked
//                    if (len > end - start) // 2 > 2 - 0 → 2 > 2 ❌ false
//                        So we do not update start and end, because "ab" is not longer than "bab".
                    start = i-(len-1)/2; //handles both even and odd lengths correctly for the left boundary.
                    end = i+len/2; // handles the right boundary.
                }

            }

          return s.substring(start,end+1);
        }

        private static int expandFromMiddle(String s, int left, int right) {
          while (left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
              Set<String> existingList = allPalindromes.getOrDefault(s, new HashSet<>());
              existingList.add(s.substring(left,right+1));
              allPalindromes.put(s, existingList);
              left--;
              right++;
          }
          return right-left-1;
        }


    private static StringBuilder find(String s) {
        int count=0;
        StringBuilder psub= new StringBuilder("");
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
//                System.out.print(s.charAt(j)+" ");
                String sub=s.substring(i,j+1);
                System.out.print(sub+" ");
                if(checkPalindrome(sub)){
                    psub.append(sub);
                }
            }
            System.out.println();
        }
        return psub;
    }

    public static String longestPalindrome_EOC(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0, end = 0;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            System.out.println(left+" "+center+" "+right);

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, end + 1);
    }

    private static boolean checkPalindrome(String sub) {
return false;
    }
}
