package com.ragul.demo.problems;


import java.util.*;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
//need to fix error - no mood but easy
public class SplitWordsByLineWithSameLine {
    public static void main(String args[]) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        Map<Integer, List<String>> line = seperateWordsbyLine(words);
        printArray(line);
        printArrayInNeatFormat(line);

    }

    private static void printArrayInNeatFormat(Map<Integer, List<String>> line) {
        int maxLen = 16;
        for(int i=0;i<line.keySet().size();i++) { //each line
            int totalLineLen = line.get(i).size();
            int extraSpaces = maxLen-totalLineLen;
            int extraSpaceAfterEachChar=extraSpaces/line.get(i).size();

            for (int j = 0; j < line.get(i).size(); j++) { //words in each line
                int z=0;
                System.out.print(line.get(i).get(j));
              while(z<=extraSpaceAfterEachChar){
                  System.out.print(" ");
                  z++;
              }
            }
            System.out.println();
        }

    }

    private static void printArray(Map<Integer, List<String>> str) {
        for(int i=0;i<str.keySet().size();i++){
            for(int j=0;j<str.get(i).size();j++){
                System.out.print(str.get(i).get(j)+" ");
            }
            System.out.println();
        }
        }

    private static Map<Integer, List<String>> seperateWordsbyLine(String[] words) {
        int maxLen = 16;
        //String[][] line = new String[words.length][maxLen];
        Map<Integer, List<String>> lineMap = new HashMap<>();
        int j=0;
        for(int i=0;i<words.length;i++){   //line array
            int currentMax=0, word=0;
            for(;j<words.length;j++){
                currentMax=currentMax+words[j].length()+1;
                if(currentMax>maxLen){
                    break;
                }else{
                    if(lineMap.containsKey(i)){
                        lineMap.get(i).add(words[j]);
                    }else{
                        lineMap.put(i, Arrays.asList(words[j]));
                    }

                    word++;
                }

            }
        }


        return lineMap;
    }


}