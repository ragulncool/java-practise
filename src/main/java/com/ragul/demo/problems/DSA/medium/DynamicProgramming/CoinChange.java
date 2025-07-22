package com.ragul.demo.problems.DSA.medium.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.
//
//
//
//Example 1:
//
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Example 2:
//
//Input: coins = [2], amount = 3
//Output: -1
//Example 3:
//
//Input: coins = [1], amount = 0
//Output: 0
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5}; //means - these coins are present in unlimited numbers
        int amount=11;
        System.out.println(coinChangeWithoutDP(coins,amount));

        //System.out.println(coinChange(coins,amount));
    }


    public static int coinChangeWithoutDP(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1; // no possible soltionm -  Cannot make change for negative amount
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = coinChangeWithoutDP(coins, amount - coin); // Recursive call
            if (result != -1) { // If a valid solution is found for the subproblem
                minCoins = Math.min(minCoins, result + 1); // Add one coin to the result
            }
        }

        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

}

//flow diagram of recursive solution
// 1. Start with the total amount to be made.
// 2. For each coin in the list of coins:
//    a. Subtract the coin value from the total amount.
//    b. Call the function recursively with the new amount.
//    c. If the recursive call returns a valid result (not -1), update the minimum number of coins needed.
// 3. If no valid combination is found, return -1.
// 4. If a valid combination is found, return the minimum number of coins needed.
// 5. If the amount is zero, return zero (base case).
// 6. If the amount is negative, return -1 (base case).
// 7. The function will explore all possible combinations of coins to find the minimum number needed to make the total amount.
