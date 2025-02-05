package com.ragul.demo.problems;

//https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
//Input: strs = ["eat","tea","tan","ate","nat","bat"]

 //       Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


import java.util.*;

public class GroupAnagrams {
    public static void main(String args[]) {
        String[] givenStr = {"eat","tea","tan","ate","nat","bat",""};
        Map<String, List<String>> groupMap= new HashMap<>();

        for(String s: givenStr){
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
           String sortedStr = String.valueOf(sArr);

            List<String> groupList = new ArrayList<>();
            if(groupMap.containsKey(sortedStr)){
                groupList = groupMap.get(sortedStr);
            }
            groupList.add(s);

            groupMap.put(sortedStr,groupList);

        }

        for(String key:groupMap.keySet()){
           List<String> list = groupMap.get(key);
            System.out.print(key+": ");
           for (String l:list){
               System.out.print(l+" ");
           }
            System.out.println();
        }

    }
}
