package com.ragul.demo.problems.Collections.String.ExpandAroundCenter.PalindromicSubString;

public class CheckStringIsPalindrome {
    public static void main(String[] args) {
        String s[]={"malayalam","abba","abdba","ababb"};
        for (int i=0;i<s.length;i++){
            System.out.println(checkPalindrome(s[i]));

        }

    }

    private static boolean checkPalindrome(String s) {
        if(s.isEmpty()) return true;

        int left=0, right = s.length()-1;

        while (left<right){ //no use of = in left<=right. it check middle inly for odd which is unnecessary
            if (s.charAt(left)==s.charAt(right)){
//                if(left==right){
//                    System.out.println("MIDDLE "+left);
//                }
                left++;
                right--;
                continue;
            }else{
                return false;
            }

        }
        return true;
    }
}
