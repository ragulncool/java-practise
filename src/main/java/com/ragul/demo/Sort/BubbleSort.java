package com.ragul.demo.Sort;

public class BubbleSort {
    //bubble - compare with each other nearby

    //n-1 comparisions
    //in each comparison bring largest number to the bottom by comparing each nearby element

    //Time Complexity	Best: O(n) - if it is already sorted or sorted in 1 cycle itself (4 1 2 3 5)
    //Average: O(n^2)      [two for loops = n x n]
    //Worst: O(n^2)
    //Space Complexity	Worst: O(1)

    public static void main(String args[]){
        int[] nums= {3,5,1,2,4};
        int[] sortedNums = doBubbleSort(nums);
       printAllElements(sortedNums);
    }

    private static void printAllElements(int[] sortedNums) {
        for(int i=0;i<sortedNums.length;i++){
            System.out.println(sortedNums[i]);
        }
    }

    private static int[] doBubbleSort(int[] nums) {
        int n=nums.length;
        boolean swapped;
        System.out.println("length - n:"+n);

        for(int i=0;i<n-1;i++){
            System.out.println("CYCLE1 - i:"+i);
            swapped = false;
            for(int j=0;j<n-1-i;j++){ //-i is reduce unncessary checks && n-1 & n are the last
                System.out.println("  CYCLE2 - j :"+j+" "+(j+1));
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    swapped=true;
                }
            }
            //printAllElements(nums);

            if(swapped==false){
                System.out.println("Breaking to avoid unnecessary execution since no more swaps required and already sorted");
                break;
            }
        }
        return nums;
    }


}
