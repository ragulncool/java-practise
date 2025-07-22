package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        String result = findMinimumWindowSubstring(s,t);
    }

    private static String findMinimumWindowSubstring(String s, String t) {
        int minlen=0;
        int start=0,end=0;



        Set<Character> t1= initiazetList(t);

        while(end<s.length()){
            char startC = s.charAt(start);
            char endC = s.charAt(end);

            while (!t1.contains(endC)){
                end++;
            }
            if (t1.isEmpty()){
                minlen=Math.min(minlen, end-start+1);
                start++;
            }

            if(t1.contains(endC)){
                t1.remove(endC);
            }

            end++;
        }
       return null;
    }

    private static Set<Character> initiazetList(String t) {
        Set<Character> t1=new HashSet<>();
        for(int i=0;i<t.length();i++){
            t1.add(t.charAt(i));
        }
        return t1;
    }
}
