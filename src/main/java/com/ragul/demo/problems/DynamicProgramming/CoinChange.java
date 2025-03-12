package com.ragul.demo.problems.DynamicProgramming;

import java.util.Arrays;


public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5}; //means - these coins are present in unlimited numbers
        int amount=11;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount){
        if(amount==0)return 0;// edge case: if the amount is 0
        int maxNum = amount + 1; // an impossible value for the solution
        int[] num_change = new int[maxNum]; // fixed-length of the array for maxNum States
        Arrays.fill(num_change, maxNum);// fill them with the impossible number
        num_change[0] = 0;// 0 means 0

        for(int i = 1; i <= amount; i ++){// from state 1 to final amount  -  amount 1 to 11
            for(int coin: coins){// check each coin, means each potential transition - 1,2,5
                // if the coin denomination is smaller than i
                // and the potential sub-solution won't reach the possible maximum number
                if(i - coin >= 0 && num_change[i - coin] <= amount){
                    //the minimal value between current one and previously recorded one
                    num_change[i] = Math.min(num_change[i], num_change[i-coin]+1);
                }
            }
        }

        if(num_change[amount] == maxNum)
            num_change[amount] = -1;// no possible solution!
        return num_change[amount];// return the result
    }
}
