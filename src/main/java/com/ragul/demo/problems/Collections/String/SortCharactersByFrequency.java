package com.ragul.demo.problems.Collections.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s="tree";
        System.out.println(BF1(s.toCharArray()));
    }

    private static String BF1(char[] c) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<c.length;i++){
            map.put(c[i],map.getOrDefault(c[i],0)+1);
        }



       return Arrays.toString(c);

    }
}
