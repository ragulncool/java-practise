package com.ragul.demo.Sort.DivideAndConq;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSortAlg {

    //sorted position si the correct position for the number - values in left are lesser or equal and values in right are greater

    //Best Case : Ω (N log (N))
    //Average Case: θ ( N log (N))
    //Worst Case: O(N ^ 2)
    //Auxiliary Space: O(1)
    public static void main(String args[]){
        int[] nums={10, 30,12,50,3};
        printAllElements(nums);

        nums = Quicksort(nums,0, nums.length-1);
        printAllElements(nums);
    }

    private static int[] Quicksort(int[] nums,int low, int high ) {
        if (low<high){
            int j = partioningPosition(nums, low, high);
            nums = Quicksort(nums, low,j);
            nums = Quicksort(nums, j+1, high);
        }
       // printAllElements(nums);
        return nums;
    }

    private static int partioningPosition(int[] nums, int low, int high) {
        int i=low;
        int j=high;
        log.info("Pivot position {} and number {}",i, nums[i]);
        int pivotCurrPosition = i;
        int pivot = nums[i];
        while (i<j) {

            while (i< high && nums[i] <= pivot) {
                 i++;
            }

            while (j>low && nums[j] > pivot) {
                j--;
             }

              if (i < j) {
                   nums = swapNumbers(nums, i, j);
              }
        }
        nums = swapNumbers(nums, pivotCurrPosition, j); //take pivot to sorted position
        return j; //new position of pivot
    }

    private static int[] swapNumbers(int[] nums, int i, int j) {
        log.info("Swapping {} from {} and {} from {}",nums[i],i, nums[j], j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    private static void printAllElements(int[] sortedNums) {
        for(int i=0;i<sortedNums.length;i++){
            System.out.println(sortedNums[i]);
        }
    }
}
