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
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            //  tough to understand. bettwe use as above
            //  cnt.merge(x, 1, Integer::sum);
            //  cnt.merge(x,1, (oldValue, newValue) -> oldValue + newValue); // count frequency of each element
        }
        // min heap based on frequency
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry);
        }

        System.out.println(pq);

        if (pq.size()>k){
            pq.poll(); // remove the least frequent element
        }

        System.out.println(pq);

        return pq.stream().mapToInt(x->x.getKey()).toArray(); //if used map() will return as Object[] instead of int[]
//        return pq.stream().mapToInt(Map.Entry::getKey).toArray(); //if used map() will return as Object[] instead of int[]
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
