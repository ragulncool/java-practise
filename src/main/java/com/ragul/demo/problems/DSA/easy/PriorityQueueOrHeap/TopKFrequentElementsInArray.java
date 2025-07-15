package com.ragul.demo.problems.DSA.easy.PriorityQueueOrHeap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElementsInArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] topKFrequentElements = findTopKFrequentElements(nums, k);
        System.out.print("Top " + k + " frequent elements are : ");
        for (int x : topKFrequentElements) {
            System.out.print(x + " ");
        }
    }

    private static int[] findTopKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq
                = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue)); // min heap based on frequency
        for (var e : cnt.entrySet()) {
            pq.offer(e); // add to priority queue
            if (pq.size() > k) {
                pq.poll(); // remove the least frequent element
            }
        }
        //for dev
        System.out.println("Priority Queue after processing all elements: " + pq);
        //just for question
        return pq.stream().mapToInt(Map.Entry::getKey).toArray(); // convert key to int array
    }


//    private static String findTopKFrequentElements(int[] nums, int k) {
//        Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
//        for (int num : nums) {
//            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//        }
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new FrequencyComparator(frequencyMap));
//        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//            queue.offer(entry.getKey());
//            if (queue.size() > k) {
//                queue.poll(); // Remove the least frequent element
//            }
//        }
//
//        return "";
//    }
//}
//
//class FrequencyComparator implements Comparator<Integer> {
//    private final Map<Integer, Integer> frequencyMap;
//
//    public FrequencyComparator(Map<Integer, Integer> frequencyMap) {
//        this.frequencyMap = frequencyMap;
//    }
//
//    @Override
//    public int compare(Integer a, Integer b) {
//        return frequencyMap.get(a) - frequencyMap.get(b); // ascending order based on frequency
        //return frequencyMap.get(b) - frequencyMap.get(a); // descending order based on frequency
//    }
}
