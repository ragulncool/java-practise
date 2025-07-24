package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Input: s = "eceba", k = 2
//Output: 3
//Explanation: T is "ece" which its length is 3.
//Example 2:
//
//Input: s = "aa", k = 1
//Output: 2
//Explanation: T is "aa" which its length is 2.
public class LongestSubstringWithK_Or_AtmostKDistinctCharacters {
    public static void main(String[] args) {
        String s[]={"geeksforgeeks","eceba","abbbbbbc","aa","aa"};
        int[] k={2,3,2,1,2};
        for (int i=0;i<s.length;i++){
            System.out.println("Input: s = \""+s[i]+"\", k = "+k[i]);
            System.out.println(findLongestSubstringUsingBruteForce(s[i],k[i],"EQUAL"));
            System.out.println(findLongestSubstringUsingSlidingWindow(s[i],k[i],"EQUAL"));
        }

        System.out.println("=========================");

        String s1[]={"geeksforgeeks","eceba","abbbbbbc","aa","aa"};
        int[] k1={2,3,2,1,2};
        for (int i=0;i<s1.length;i++){
            System.out.println("Input: s = \""+s1[i]+"\", k = "+k1[i]);
            System.out.println(findLongestSubstringUsingBruteForce(s1[i],k1[i],"ATMOST"));
            System.out.println(findLongestSubstringUsingSlidingWindow(s1[i],k1[i],"ATMOST"));
        }
        //aa k=2 is the difference between EQUAL and ATMOST
        //for EQUAL, we need exactly k distinct characters . hence "aa" is 0
        //for ATMOST, we can have atmost k distinct characters. hence "aa" is 2

    }

    private static int findLongestSubstringUsingBruteForce(String s, int k, String MODE) {
        int maxLength=0;
        Set<Character> visited = new HashSet<>();

        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                visited.add(s.charAt(j));

                if(MODE.equals("EQUAL") && visited.size()==k){
                    maxLength = Math.max(maxLength,j-i+1);
                   // System.out.println("MaxLen "+i+" "+j);
                }else if(MODE.equals("ATMOST") && visited.size()<=k){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
            visited.clear();;
        }
        return maxLength;
    }

    //wrong
    private static int findLongestSubstringUsingSlidingWindow(String s, int k, String MODE) {
        int maxLength=0;

        int start=0,end=0;
        Map<Character,Integer> visited = new HashMap<>();

        while (end<s.length()){
            char startC= s.charAt(start);
            char endC= s.charAt(end);

            while (visited.size()>k){
                decrementOrClearMap(visited,startC);
                start++;
            }
            incrementMap(visited,endC);

            if(MODE.equals("EQUAL") && visited.size()==k){ //for atmost k, we can use visited.size()<=k
              //  System.out.println("Start: "+start+" End: "+end+" Length: "+(end-start+1)+" Substring: "+s.substring(start,end+1));
                maxLength=Math.max(maxLength,end-start+1);
            }else if(MODE.equals("ATMOST") && visited.size()<=k){
                    //System.out.println("Start: "+start+" End: "+end+" Length: "+(end-start+1)+" Substring: "+s.substring(start,end+1));
                    maxLength=Math.max(maxLength,end-start+1);
            }
            end++;
        }


        return maxLength;
    }

    private static void incrementMap(Map<Character, Integer> visited, char endC) {
        if(visited.containsKey(endC)){
            visited.put(endC,visited.get(endC)+1 );
        }else{
            visited.put(endC,1);
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
