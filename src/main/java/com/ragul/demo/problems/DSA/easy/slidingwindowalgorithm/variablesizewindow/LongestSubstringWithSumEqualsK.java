package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

//Longest substring with sum <=k - we can optimize below code by replace while loop with if in L19
//number of subarrays with sum <=k -> use count++ in Line26
//shortest or minimum substring with sum <=k -> use minLength = Math.min(minLength, end - start + 1) in Line 30
public class LongestSubstringWithSumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 7;
        System.out.println(findLongestSubstringWithSumEqualsK(arr, k));
        System.out.println(findShortestSubstringWithSumEqualsK(arr, k)); //use minLength = Math.min(minLength, end - start + 1) in Line 30
    }

    private static int findShortestSubstringWithSumEqualsK(int[] arr, int k) {
        int start = 0, end = 0, currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < arr.length) {
            currentSum += arr[end];

            while (currentSum > k && start <= end) { //shrink the window from the start until we find valid window
                currentSum -= arr[start];
                start++;
            }

            if (currentSum <= k) { //valid window found
                System.out.println("Sum " + currentSum + " found between indices " + start + " [" + arr[start] + "] and " + end + " [" + arr[end] + "]");
                minLength = Math.min(minLength, end - start + 1);
            }
            end++;
        }

        return minLength;
    }

    private static int findLongestSubstringWithSumEqualsK(int[] arr, int k) {
        int start = 0, end = 0, currentSum = 0;
        int maxLength = 0;

        while (end < arr.length) {
            currentSum = currentSum + arr[end];

            while (currentSum > k) { //since all elements are positive, we can shrink the window from the start until we find valid window
                currentSum = currentSum -  arr[start];
                start++;
            }

            //once valid winodw is found, do not shrink it further and do operations
            if(currentSum <= k) { //not needed, but for clarity since we are looking for sum <= k
                System.out.println("Sum "+currentSum+" found between indices " + start+" ["+arr[start] + "] and " + end+" ["+arr[end] + "]");
                maxLength = Math.max(maxLength, end - start + 1);
            }
            end++;
        }

        return maxLength;
    }
}
