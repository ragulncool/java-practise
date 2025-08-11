package com.ragul.demo.problems.Collections.Recursion;

public class Palindrome {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,2,1};

        System.out.println(checkPalindrome123(0,arr.length-1,arr));
    }

    private static boolean checkPalindrome123(int i, int j, int[] arr) {
        if(i>=j) return true; //put = will avoid another recursive call thougn output is not affected

        if(arr[i]!=arr[j]){
            return false;
        }

        return checkPalindrome123(i+1,j-1,arr);
    }
}
