package com.ragul.demo.problems.DSA.Collections.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfGoodWaysToSplitAString {
    public static void main(String[] args) {
        String[] s={"aacaba","abcd"};
        for (int i=0;i<s.length;i++){
            System.out.println(findWays(s[i]));
        }
    }
 //both O(n)
    private static int findWays(String s) {
        Map<Character,Integer> prefixUnique = new HashMap<>();
        Map<Character,Integer> suffixUnique = new HashMap<>();
        int noOfGoodWays = 0;

        for (int i=0;i<s.length();i++) {
            suffixUnique.put(s.charAt(i),suffixUnique.getOrDefault(s.charAt(i),0)+1);
        }

            for (int i=0;i<s.length();i++) {

                    prefixUnique.put(s.charAt(i), prefixUnique.getOrDefault(s.charAt(i), 0) + 1);

                suffixUnique.put(s.charAt(i),suffixUnique.get(s.charAt(i))-1);

                if (suffixUnique.get(s.charAt(i))==0) suffixUnique.remove(s.charAt(i));


               // System.out.println(i+" "+ prefixUnique.size()+ " "+suffixUnique.size());

            if(prefixUnique.size()==suffixUnique.size()){
                    noOfGoodWays++;
                }
            }



        return noOfGoodWays;
    }
}
