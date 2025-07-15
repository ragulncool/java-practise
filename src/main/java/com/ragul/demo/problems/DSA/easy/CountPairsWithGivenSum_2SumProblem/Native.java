package com.ragul.demo.problems.DSA.easy.CountPairsWithGivenSum_2SumProblem;

//O(n2) time and O(1) since only cnt needs to be stored

//Input: arr[] = {1, 5, 7, -1, 5}, target = 6
//        Output:  3
//        Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).
//
//
//        Input: arr[] = {1, 1, 1, 1}, target = 2
//        Output:  6
//        Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1) and (1, 1).
//
//
//        Input: arr[] = {10, 12, 10, 15, -1}, target = 125
//        Output:  0
public class Native {
    public static void main(String args[]){
        //Given
        int[] arr = {1, 1, 1, 1};//{1,5,7,-1,5};
        int sum=2;

        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==sum){
                    System.out.println("Pair "+arr[i]+" "+arr[j]);
                    count++;
                }
            }
        }

        System.out.println("Count of pairs: "+count);
    }
}
