package com.ragul.demo.problems.DSA.medium.DynamicProgramming;

public class MaximumProfitFromSaleofWines {
    public static void main(String[] args) {
        int[] wines = {2, 4, 6, 2, 5};//{2, 3, 5, 1, 4};
        System.out.println("Maximum profit from sale of wines: " + maxProfit(wines, 0, wines.length - 1, 1));

        //MAXIMUM PROFIT FROM SALE OF WINES USING DP
        int[][] dp = new int[wines.length][wines.length];
        for (int i = 0; i < wines.length; i++) {
            for (int j = 0; j < wines.length; j++) {
                dp[i][j] = -1; // Initialize DP table with -1
            }
        }
        System.out.println("Maximum profit from sale of wines using DP: " + maxProfitDP(wines, 0, wines.length - 1, 1, dp));
        System.out.println("     2  4  6  2  5");
        System.out.println("     0  1  2  3  4");
        System.out.println("-------------------");
        for (int i = 0; i < wines.length; i++) {
            System.out.print( i + " |  ");
            for (int j = 0; j < wines.length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int maxProfitDP(int[] wines, int start, int end, int year, int[][] dp) {
        if (start > end) {
            return 0;
        }

        // Check if the result is already computed
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // Calculate profit from selling the leftmost wine
        int leftProfit = wines[start] * year + maxProfitDP(wines, start + 1, end, year + 1, dp);

        // Calculate profit from selling the rightmost wine
        int rightProfit = wines[end] * year + maxProfitDP(wines, start, end - 1, year + 1, dp);

        // Store the maximum of the two profits in DP table
        dp[start][end] = Math.max(leftProfit, rightProfit);
        System.out.println("Profit from wines index[" + start+"["+wines[start]+"]"  + " to " + end + "["+wines[end]+"]"+" in year " + year + ": " + leftProfit+" "+rightProfit);

        return dp[start][end];
    }

    private static int maxProfit(int[] wines, int start, int end, int year) {
        if(start==end){
          //  return wines[start] * year; // If there's only one wine left, sell it
            //alternate
            return wines[end]*year; //start and end are same since only one element exist
        }

        // choice 1 - Calculate profit from selling the leftmost wine
        int leftProfit = wines[start] * year + maxProfit(wines, start + 1, end, year + 1);

        // choice 2 - Calculate profit from selling the rightmost wine
        int rightProfit = wines[end] * year + maxProfit(wines, start, end - 1, year + 1);

        // Return the maximum of the two profits
        return Math.max(leftProfit, rightProfit);
    }
}
