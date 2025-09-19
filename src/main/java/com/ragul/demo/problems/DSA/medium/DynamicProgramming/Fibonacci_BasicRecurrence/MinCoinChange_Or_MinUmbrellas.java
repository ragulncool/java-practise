package com.ragul.demo.problems.DSA.medium.DynamicProgramming.Fibonacci_BasicRecurrence;

public class MinCoinChange_Or_MinUmbrellas {

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {2,3,5};
        System.out.println(findMinCoins(amount,coins));
    }

    private static int findMinCoins(int amount, int[] coins) {
        int[] dpMinCoins = new int[amount+1];
        // Base case: 0 coins needed for amount 0 - no need to mention. it auto does
       // dpMinCoins[0] = 0;

        for (int currAmt=1;currAmt<dpMinCoins.length;currAmt++){
            dpMinCoins[currAmt] = Integer.MAX_VALUE;

            for (int coin:coins){
                if(currAmt>=coin && dpMinCoins[currAmt-coin]!=Integer.MAX_VALUE){
                    dpMinCoins[currAmt] = Math.min( dpMinCoins[currAmt], 1+dpMinCoins[currAmt-coin]); //1+ means add 1 current coin
                }
            }
            System.out.println("DP of "+currAmt+" is : "+dpMinCoins[currAmt]);
        }

        return dpMinCoins[amount]==Integer.MAX_VALUE?-1:dpMinCoins[amount];
    }
}
