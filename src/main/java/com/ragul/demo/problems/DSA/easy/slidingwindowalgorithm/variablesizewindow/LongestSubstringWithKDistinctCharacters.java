package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String s="geeksforgeeks";
        int k=2;
        System.out.println(findLongestSubstringUsingBruteForce(s,k));

        System.out.println(findLongestSubstringWithKDistinctChar(s,k));
    }

    private static int findLongestSubstringUsingBruteForce(String s, int k) {
        int maxLength=0;
        Set<Character> visited = new HashSet<>();

        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                visited.add(s.charAt(j));

                if(visited.size()==k){
                    maxLength = Math.max(maxLength,j-i+1);
                    System.out.println("MaxLen "+i+" "+j);
                }
            }
            visited.clear();;
        }
        return maxLength;
    }

    //wrong
    private static int findLongestSubstringWithKDistinctChar(String s, int k) {
        int maxLength=0;

        int start=0,end=0;
        Map<Character,Integer> visited = new HashMap<>();

        while (end<s.length() && start<=end){
            char startC= s.charAt(start);
            char endC= s.charAt(end);

            while (visited.size()>k){
                decrementOrClearMap(visited,startC);
                start++;
            }
            maxLength=Math.max(maxLength,end-start+1);
            incrementMap(visited,endC);
            end++;
        }


        return maxLength;
    }

    private static void incrementMap(Map<Character, Integer> visited, char endC) {
        if(visited.containsKey(endC)){
            visited.put(endC,visited.get(endC)+1 );
        }else{
            visited.put(endC,0);
        }
    }

    private static void decrementOrClearMap(Map<Character, Integer> visited, char startC) {
        if(visited.containsKey(startC)) {
            int c = visited.get(startC);
            if (c == 1) visited.remove(startC);
            else visited.put(startC, visited.get(startC) - 1);
        }
    }
}
