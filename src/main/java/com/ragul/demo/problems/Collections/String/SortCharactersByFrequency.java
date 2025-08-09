package com.ragul.demo.problems.Collections.String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String[] s={"tree","cccaaa","Aabb"};
        for(int i=0;i<s.length;i++){
            System.out.println(BF1(s[i].toCharArray()));
        }

    }

    private static String BF1(char[] c) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<c.length;i++){
            map.put(c[i],map.getOrDefault(c[i],0)+1);
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b)->map.get(b)-map.get(a));

        for (Character d:map.keySet()){
            priorityQueue.add(d);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!priorityQueue.isEmpty()){
           char e =  priorityQueue.poll();
            for (int i=0;i<map.get(e);i++){
                stringBuilder.append(e);
            }
        }


       return stringBuilder.toString();

    }
}
