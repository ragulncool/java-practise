package com.ragul.demo.problems.DSA.easy.TwoPointers.OppositeEnds_ConvergingPointers_ShrinkingWindow;

public class ReverseString {
    public static void main(String args[]){
        char[][] ch = {{'h','e','l','l','o'},{'H','a','n','n','a','h'}};
        for (int i=0;i<ch.length;i++){
            System.out.println(reverseString1(ch[i]));
        }
    }

    //Time - O(n), Space - O(n)
    private static char[] reverseString(char[] givenC) {
        char[] newC =new char[givenC.length];
        int first=givenC.length-1, second=0;

        while (first>=0){
            newC[second]= givenC[first];
            first--;
            second++;
        }
        return newC;
    }

    //Time - O(n), Space - O(1) - without creating new
    private static char[] reverseString1(char[] givenC) {
        int left=0, right=givenC.length-1;

        while (left<right){
            swapLetters(givenC, left, right);
            left++;
            right--;
        }
        return givenC;
    }

    private static char[] swapLetters(char[] givenC, int left, int right) {
        char temp = givenC[left];
        givenC[left] = givenC[right];
        givenC[right]=temp;
        return givenC;
    }
}
