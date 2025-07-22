package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/description/
public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] fruits = new int[]{1,2,1};
        System.out.println(findMaxFruits(fruits));

        int[] fruits1 = new int[]{0,1,2,2};
        System.out.println(findMaxFruits(fruits1));

        int[] fruits2 = new int[]{1,2,3,2,2};
        System.out.println(findMaxFruits(fruits2));
    }

    private static int findMaxFruits(int[] fruits) {

        Map<Integer,Integer> basket = new HashMap<>();

        int start=0,end=0,maxCount = 0;

        while (end<fruits.length){
//not sure why conditionis checked after putting unlike others
            basket.put(fruits[end],basket.getOrDefault(fruits[end], 0)+1);
            if(basket.size()>2){ //remove start element from basket
                basket.put(fruits[start],basket.get(fruits[start])-1);
                if(basket.get(fruits[start])==0){
                    basket.remove(fruits[start]);  //alternate    basket.remove(fruits[start],0);
                }
                start++;
            }
            maxCount=Math.max(maxCount, end-start+1);
            end++;
        }

        return maxCount;
    }
}
