package com.ragul.demo;


import java.util.Arrays;



public class CheckStringsAreClose {

    //if all char1 is repladed by char2, world should be same

    //-ve
    //when length of two words are not equals
    // when element in one is not present in another

      public static void main(String args[]) {
        System.out.println(closeStrings("aabc","bbac"));
      }


        public static boolean  closeStrings(String word1, String word2) {
            if(word1.length()!=word2.length()) return false;

            int[] w1=new int[26];             //contains count eg: no of a is stored in w1[0]
            int[] w2=new int[26];

            for(char c:word1.toCharArray()){ //O/P {2,1,1,0,0....}
                //w1[c-'a']++;  Easy notation
                    w1[c-'a'] = w1[c-'a']+1;
            }

            //printing contents of array
            for(int c: w1){
                System.out.println(c);
            }


            for(char c:word2.toCharArray()){ //O/P {1,2,1,0,0....}
                w2[c-'a']++;
            }

            //Step1:
            for(int i=0;i<26;i++){
                if((w1[i]==0 && w2[i]!=0) || (w1[i]!=0 && w2[i]==0)){
                    return false;
                }
            }

            //Step 2:
            Arrays.sort(w1); //1,1,2
            Arrays.sort(w2); //1,1,2

            return Arrays.equals(w1,w2);
        }

}


