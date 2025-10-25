package com.ragul.demo.problems.DSA.medium.BinarySearch_O_logN.FindFirst_and_lastOccurence;

public class FirstLastOccurence {
    public static void main(String[] args) {
        int[] nums={1,3,5,5,7,7,7,9,11,12};
        int a[]={5,7,9};
        for (int i=0;i<a.length;i++){
            System.out.println("First occurence of "+a[i]+" - "+findFirstOccurence(nums,a[i],0,nums.length-1));
            System.out.println("Last occurence of "+a[i]+" - "+findLastOccurence(nums,a[i],0,nums.length-1));
        }
    }

    private static int findFirstOccurence(int[] nums, int a, int low, int high) {
        int result=-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(a==nums[mid]) {
               // return mid;
                result=mid;
                high=mid-1;
            }
            else if (a<nums[mid]) high = mid-1;
            else low=mid+1;
        }
        return result;
    }

    private static int findLastOccurence(int[] nums, int a, int low, int high) {
        int result=-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(a==nums[mid]) {
                // return mid;
                result=mid;
                low=mid+1; // high=mid-1;
            }
            else if (a<nums[mid]) high = mid-1;
            else low=mid+1;
        }
        return result;
    }


}
