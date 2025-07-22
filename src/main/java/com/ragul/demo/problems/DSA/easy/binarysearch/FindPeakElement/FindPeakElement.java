package com.ragul.demo.problems.DSA.easy.binarysearch.FindPeakElement;


//SEE NOTES
//https://www.youtube.com/watch?v=cXxmbemS6XM
//Time complexity: O(log n), Space complexity: O(1)
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        //EDGE CASES

        // Handle edge case of single element
        if (nums.length == 1) {
            return 0; // Return the index of the only element
        }

        //if first element is peak
        if(nums[0]> nums[1]){ //nums[0]>-INF
          return nums[0];
        }

        //if last element is peak
        if(nums[nums.length-1]> nums[nums.length-2]){  //nums[nums.length-1]>-INF
            return nums[nums.length-1];
        }

        //MAIN CASES
        int left = 1, right = nums.length - 2;

        while (left <= right) {
            int mid = (right+left)/2;// left + (right - left) / 2;

//           comibing with edge cases above
//            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
//                return mid; // Return the index of the peak element
//            }

            if ( nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid; // Return the index of the peak element
            }

           // Compare mid with the next element
            // If mid is less than next, peak must be on the right
             else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                 // If mid is greater than or equal to next, peak could be at mid or left
                right = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        int peakIndex = findPeakElement(nums);
        System.out.println("Peak found at index: " + peakIndex + " (value: " + nums[peakIndex] + ")");

        int peakIndex1 = findPeakElementNonEfficient(nums);
        System.out.println("Peak found at index: " + peakIndex1 + " (value: " + nums[peakIndex1] + ")");
    }

    //Time complexity: O(n), Space complexity: O(1)
    private static int findPeakElementNonEfficient(int[] nums) {
        if(nums[0] > nums[1]){
            return nums[0]; // Return the index of the peak element
        }
        if(nums[nums.length-1]> nums[nums.length-2]){  //nums[nums.length-1]>-INF
            return nums[nums.length-1];
        }
        for(int i=1;i<nums.length-2;i++){
            if(nums[i]>nums[i-1] && nums[i] > nums[i+1]){
                return i; // Return the index of the peak element
            }
        }
        return -1; // If no peak found, return -1 (or handle as needed)
    }
}
