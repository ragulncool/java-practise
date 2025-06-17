package com.ragul.demo.problems.slidingwindowalgorithm.variablesizewindow;

//not working
public class CountOfSubArraysWithGivenSum {
    public static void main(String args[]) {
        String s="1245634";
        int givenSum=6;
     //   System.out.println(brutalApproach(s));
        System.out.println(slidingWindowApproach(s,givenSum));
    }


//    private static int brutalApproach(String s) {
//        int maxlength = 0;
//
//        for (int i=0;i<s.length();i++) {
//            boolean[] visited = new boolean[256];
//           // int windowlen = 0; commented code are my logic
//
//            for (int j = i; j < s.length(); j++) {
//                char c = s.charAt(j);
//
//                if (visited[c]) {
//                   // maxlength=Math.max(windowlen,maxlength);
//                    break;
//                } else {
//                   // windowlen++;
//                    maxlength = Math.max(j-i+1, maxlength); //NOTE: for single char, it will be 1
//                    visited[c] = true;
//                }
//            }
//        }
//        return maxlength;
//    }

    private static int slidingWindowApproach(String s, int givenSum) {

        int left=0, right =0;
        int sum=0;

        while (right<s.length()){
           sum=sum+s.charAt(right);

           if(sum==givenSum){
               return right-left+1;
           }else if(sum>givenSum){
               while (sum<givenSum) {
                   sum = sum - s.charAt(left);
                   left++;
               }
           }
           right++;
        }
        return -1;
    }

}
