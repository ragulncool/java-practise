package com.ragul.demo.problems.DSA.medium.BinarySearch_O_logN;


//min is the smallest element of array or first element of sorted array

//eg 3 4 5 1 2
//if eg: midElement=5=>  mid > mid+1 => then mid+1 is min or dropping point
// if eg: midElement=1=> mid<mid-1, then mid is min
// 3 4 5 6 7 1 2 , low=3,mid=6 => if lowElement < MidElement=> array is sorted and search in right side low=mid+1
//else search in left side high=mid-1
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int numss[][] = {{5,6,7,8,9, 1,2,3,4},{5,6,7,8,1,2,3,4},{5,6,7,8,9,10,11,2,3}};
        for(int[] nums:numss){
            System.out.println(findMinimum(nums,0,nums.length-1));
        }
    }

    //Brutal - search element and compare with min - O(n)
    //O(log n), O(1)
    private static int findMinimum(int[] nums,int low, int high) {
        //special cases
        if(nums.length==0) return -1;
        if (nums.length==1) return nums[0];
        if(nums[0]<nums[nums.length-1])  return nums[0]; //if sorted arary


        while (low<=high){
           int mid = low+ (high-low)/2;

           if(mid<high && nums[mid]>nums[mid+1]) return mid+1; //check bounds and then check condition
           if(mid>low && nums[mid]<nums[mid-1]) return mid;

           if(nums[low]<=nums[mid]) low=mid+1;
           else high=mid-1;
           }
        return -1;
    }
}
