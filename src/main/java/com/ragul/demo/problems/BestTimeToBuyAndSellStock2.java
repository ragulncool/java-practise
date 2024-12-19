package com.ragul.demo.problems;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String args[]) {

        int[] prices = {1,2,3,4,5,1};//{7, 1, 5, 3, 6, 4};//{7,6,4,3,1};
        findMaxProfit(prices);
    }

    public static void findMaxProfit(int[] prices) {
        int min = prices[0], max = 0, profit=0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                if(i!=0) {
                    if (max <= min) {
                        profit = 0;
                    } else {
                        profit = max - min;
                    }
                    System.out.println("MIN: " + min + "  MAX :" + max + "    PROFIT:" + profit);
                }

                min = prices[i];
                max=0;
            } else if(prices[i]>max) {
                max = prices[i];



               // min=prices[i+1];// reset min to 0
            }

            }
        }


    }
