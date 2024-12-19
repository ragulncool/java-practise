package com.ragul.demo.problems;
//https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
public class GasStation {
    public static void main(String args[]) {
        int[] gas= {1,2,3,4,5};
        int[] cost = {3,4,5,1,2}; //increase 5 for false scanrio
        int start=3;
        System.out.println(start+" "+gas[start]);


        System.out.println(checkCircuitPossible(gas,cost,start));

    }

    private static boolean checkCircuitPossible(int[] gas, int[] cost, int start) {
        int currentgasInTank = gas[start];
        int prev = -1; int next=-1;
        int current = start;
        int crossedSource=0;
        for(int i=0;i<=gas.length;i++,crossedSource=1){
            //calc prev and next
            if(current==gas.length-1){
                next=0;
                prev=current;
            }else if(current==0){
                next=current+1;
                prev=gas.length-1;
            }else{
                next=current+1;
                prev=current-1;
            }

            if(current==start && crossedSource==1) {
                return true;
            }else if(currentgasInTank>=cost[current]){ //go to next point
                prev=current;
                current=next;
                currentgasInTank = currentgasInTank + gas[current] - cost[prev];
                System.out.println(current+" "+currentgasInTank);
           }else{
               return false;
           }

        }
        return false;
    }
}