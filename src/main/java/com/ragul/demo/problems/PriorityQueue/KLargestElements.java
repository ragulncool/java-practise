package com.ragul.demo.problems.PriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//similar
//K smallest element
//kth largest or smallest element in an array

//min PriorityQueue - stores in asc order - removes smallest element on poll
//max PriorityQueue - stores in desc order - removes largest element on poll

//Priority Queue - peek returns head / top element and poll removes head / top element
//for small in head PQ - smallest value will be head so easy to remove
public class KLargestElements {
    public static void main(String args[]) {
            Integer[] nums = {2,5,1,4,6,8};
            int k=3;
            //printKLargestElementsUsingSort(nums,k);
            printKLargestElementsUsingHeap(nums,k);
            printKthLargestElementUsingHeap(nums,k);
            printKthSmallestElementUsingHeap(nums,k);
    }

    private static Integer printKthSmallestElementUsingHeap(Integer[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a); //Large in head PQ

        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);

            if(queue.size()>k){
                queue.poll(); //remove all largest element > k
            }
        }
        System.out.print("kth smallest number : "+queue.peek());
        return queue.peek(); //first largest of min number
    }

    private static Object printKthLargestElementUsingHeap(Integer[] nums, int k) {
        PriorityQueue queue = new PriorityQueue(); //Small in head PQ

        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);

            if(queue.size()>k){
                queue.poll(); //remove all smallest element > k
            }
        }
        System.out.print("kth largest number : "+queue.peek());
        return queue.peek(); //min of largest element
    }

    private static void printKLargestElementsUsingHeap(Integer[] nums, int k) {
        PriorityQueue queue = new PriorityQueue(); //minHeap

        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);

            if(queue.size()>k){ //to reduce another for - we remove samallest eleemt > k, only smallest of all array is removed
                queue.poll();
            }
        }

//        for(int i=0;i< nums.length-k;i++){
//            System.out.println("REMOVED: "+queue.poll()+" ");
//        }

        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" "); //pollong here for dev to understadn elements in queue
        }
    }

    private static void printKLargestElementsUsingSort(Integer[] nums, int k) {
        Arrays.sort(nums, Collections.reverseOrder());
        for(int i=0;i<k;i++){
            System.out.print(nums[i]+" ");
        }
        //if kth largest element -
        // sort desc and print num[k-1]
        System.out.println(" "+k+"th largest element : "+nums[k-1]);
    }
}
