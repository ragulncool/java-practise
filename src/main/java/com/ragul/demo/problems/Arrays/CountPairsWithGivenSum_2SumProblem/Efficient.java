package com.ragul.demo.problems.Arrays.CountPairsWithGivenSum_2SumProblem;

import java.util.HashMap;
import java.util.Map;

//O(n) - time and space
//space - we havew to store constant cnt and n in freq map
public class Efficient {

        // Returns number of pairs in arr[0...n-1] with
        // sum equal to 'target'
        static int countPairs(int[] arr, int target) {
            Map<Integer, Integer> freq = new HashMap<>();
            int cnt = 0;

            for (int i = 0; i < arr.length; i++) {

                // Check if the complement (target - arr[i])
                // exists in the map. If yes, increment count
                if (freq.containsKey(target - arr[i])) {
                    cnt += freq.get(target - arr[i]);
                }

                // Increment the frequency of arr[i]
                freq.put(arr[i],
                        freq.getOrDefault(arr[i], 0) + 1);
            }
            return cnt;
        }

        public static void main(String[] args) {
            int[] arr = {1, 5, 7, -1, 5};
            int target = 6;
            System.out.println(countPairs(arr, target));
        }
    }

