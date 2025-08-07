package com.ragul.demo.problems.Collections.String;

import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        String s="malayalam1";
        System.out.println(checkPalindrome11(s));
        System.out.println(checkPalindrome2(s));


    }

    //time O(n), Space O(n) -
    private static boolean checkPalindrome11(String s) {
        String reversedUsingForLoop = reverseStringUsingFor(s.toCharArray());
        String reversedUsingWhileLoop = reverseStringUsingWhile(s.toCharArray());
        System.out.println(reversedUsingForLoop);
        System.out.println(reversedUsingWhileLoop);


        return reversedUsingForLoop.equals(s);
    }

    private static String reverseStringUsingWhile(char[] c) {
        int start=0, end=c.length-1;
        while (start<end){
            char temp = c[start];
            c[start]=c[end];
            c[end]=temp;

            start++; end--;
        }
        return Arrays.toString(c);
    }

    private static String reverseStringUsingFor(char[] s) {
        for (int i=0;i<s.length/2;i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
        return Arrays.toString(s);
    }

    //time O(n), Space O(1)
    private static boolean checkPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }


        int start=0, end=s.length()-1;
        while (start<end){ //start<=end produce same result but not needed
            if(s.charAt(start)!=s.charAt(end))
                    return false;

            start++;
            end--;
        }
        return true;
    }

}
