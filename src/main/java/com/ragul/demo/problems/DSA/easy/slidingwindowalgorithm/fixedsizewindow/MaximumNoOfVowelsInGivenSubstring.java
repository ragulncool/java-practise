package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.fixedsizewindow;

public class MaximumNoOfVowelsInGivenSubstring {
    public static void main(String[] args) {
        String[] s= {"abciiidef","aeiou", "leetcode"};
        int[] k={3,2,3};
        for (int i=0; i<s.length; i++){
            System.out.println("Maximum number of vowels is: " + maxVowels(s[i].toCharArray(), k[i]));
        }
    }

    private static int maxVowels(char[] c, int k) {

        if (c == null || c.length < k || k <= 0) return 0;

        int  currentWindowVowelCount=0, maxVowelCount = 0;

        //initial window
        for(int i=0;i<=k-1;i++){
            if(isVowel(c[i])){
                currentWindowVowelCount++;
            }
        }
        maxVowelCount = currentWindowVowelCount;

        for(int i=k;i<c.length;i++){
            //extend end
            if(isVowel(c[i])) currentWindowVowelCount++;

            //shrink start
            if(isVowel(c[i-k])) currentWindowVowelCount--;

            maxVowelCount =  Math.max(currentWindowVowelCount, maxVowelCount);
        }

        //other working diff way
//        //sliding window
//        while(end<c.length-1){
//            //move start
//            if(isVowel(c[start])){
//                currentWindowVowelCount--;
//            }
//            start++;
//
//            //move end
//            end++;
//            if(isVowel(c[end])){
//                currentWindowVowelCount++;
//            }
//            maxVowelCount =  Math.max(currentWindowVowelCount, maxVowelCount);
//        }

        return maxVowelCount;
    }

    private static boolean isVowel(char c) {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
}
