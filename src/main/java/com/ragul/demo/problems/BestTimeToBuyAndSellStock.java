package com.ragul.demo.problems;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
public class BestTimeToBuyAndSellStock {
    public static void main(String args[]) {

        int[] prices = {7,6,4,3,1};//{7, 1, 5, 3, 6, 4};
        findMaxProfit(prices);
    }

    public static void findMaxProfit(int[] prices) {
        int min = 1, max = 0, profit=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
                max=0;
            } else if (prices[i] > max) {
                max = prices[i];
            }
        }
            if (max <= min) {
                profit=0;
            } else {
                profit =  max - min;
            }
            System.out.println("MIN: "+min+"  MAX :"+max+"    PROFIT:"+profit);

    }
}