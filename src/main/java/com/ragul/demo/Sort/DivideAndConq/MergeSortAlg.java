package com.ragul.demo.Sort.DivideAndConq;

public class MergeSortAlg {

    // Divide the array into two sub arrays, sort them and merge them
    static void mergeSort(int[] nums, int low, int high){
        if(low<high){
            int mid = (low + high) / 2;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);

            // Merge the sorted sub arrays
            merge(nums,low, mid,high);
       }
    }

     static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        // fill the left and right array
        for (int i = 0; i < n1; i++)
            left[i] = array[low + i];
        for (int j = 0; j < n2; j++)
            right[j] = array[mid + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = low;
         while (i < n1 && j < n2) {

             if (left[i] <= right[j]) {
                 array[k] = left[i];
                 i++;
                 k++;
             } else {
                 array[k] = right[j];
                 j++;
                 k++;
             }
         }

        //all remaining elements will be order
        //i will be lesser than j
        while(i<left.length){
            array[k]=left[i];
            i++; k++;
        }
        while(j<right.length){
            array[k]=right[j];
            j++; k++;
        }

    }

    public static void main(String args[]){
        int[] nums={2,1,5,3,4};
        mergeSort(nums,0,nums.length-1);
    }

    private static void printAllElements(int[] sortedNums) {
        System.out.println("---");
        for(int i=0;i<sortedNums.length;i++){
            System.out.println(sortedNums[i]);
        }
    }
}
