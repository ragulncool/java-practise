package com.ragul.demo.problems.DSA.easy.PriorityQueueOrHeap.FindMedianInDataStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Time Complexity: O(NlogN) for sorting the list every time we find the median

//abobe is time complexity for Collections.sort and no floop. hence it is the complexoty for entire program
public class FindMedianInDataStream {
    List<Integer> list;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


    FindMedianInDataStream(){
        list=new ArrayList<>();
    }

    public static void main(String[] args) {
        //brutal force approach - O(NlogN) time complexity, space complexity O(N)
        FindMedianInDataStream medianFinder = new FindMedianInDataStream();
        medianFinder.addNum(3);
        medianFinder.addNum(2);
        System.out.println("Median after adding 1 and 2: " + medianFinder.findMedian());
        medianFinder.addNum(7);
        medianFinder.addNum(4);
        System.out.println("Median after adding 3: " + medianFinder.findMedian());

        //using heap
        //brutal force approach - O(logN) time complexity, space complexity O(N)

        medianFinder.addNumusingHeap(3);
        medianFinder.addNumusingHeap(2);
        System.out.println("Median after adding 1 and 2: " + medianFinder.findMedianUsingHeap());
        medianFinder.addNumusingHeap(7);
        medianFinder.addNumusingHeap(4);
        System.out.println("Median after adding 3: " + medianFinder.findMedianUsingHeap());

    }

    //Time compleixty - O(1) - heap peek operation
    private double findMedianUsingHeap() {

        if (minHeap.size() == maxHeap.size()){  //means even number of elements eg: 3, 3
                return (minHeap.peek()+maxHeap.peek())/2.0;
            }else {
                return maxHeap.peek();
            }

    }

    //Time compleixty - O(log N) - heap insert operation

    private void addNumusingHeap(int num) {
        //maxHeap contains the smaller half of the numbers (left) - returns largest element on peek, will contain smallesy
        //minHeap contains the larger half of the numbers (right) - returns smallest element on peek, will contain largest
        //should be min Heap<= max Heap
        maxHeap.add(num);
        System.out.println("After adding in minHeap "+maxHeap+" "+minHeap);
        minHeap.add(maxHeap.poll()); //add the smallest element from minHeap to maxHeap
        System.out.println("After adding in maxHeap "+maxHeap+" "+minHeap);
        if(minHeap.size()>maxHeap.size()){ //if maxHeap has more elements than minHeap, then we need to balance the heaps
            maxHeap.add(minHeap.poll());
            System.out.println("After balancing "+maxHeap+" "+minHeap);
        }
    }

    //Time comexity nlogn - sort
    private double findMedian() {
        int n=list.size();

        Collections.sort(list);
        if(n%2==0){
            double median = (list.get(n/2  -1)+list.get(n/2))/2.0;
            return median;
        }else {
            return list.get(n/2);
        }
    }

    //O(1)
    private void addNum(int i) {
        list.add(i);
    }

    // Implement the methods to add numbers and find the median
    // Use two heaps (max heap for lower half and min heap for upper half)
    // to maintain the balance of the data stream.
}
