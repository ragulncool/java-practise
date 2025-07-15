package com.ragul.demo.problems.DSA.medium.DynamicProgramming;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

//A "LeetCode umbrella dynamic programming" problem would typically involve a scenario where you need
//        to find the minimum number of umbrellas needed to shelter a given number of people,
//        given different types of umbrellas with varying capacities, using a dynamic programming approach
//        to optimize the solution by breaking down the problem into smaller, overlapping subproblems.

public class MonsoonUmbrella {

        public static int minUmbrellas(int numOfPeople, int[] umbrellaSizes) {
            int[] result = new int[numOfPeople + 1];
            Arrays.fill(result, -1); // Initialize memo with -1 (indicating not computed)
            return minUmbrellasRecursive(numOfPeople, umbrellaSizes, result);
        }

        private static int minUmbrellasRecursive(int numOfPeople, int[] umbrellaSizes, int[] result) {
            if (numOfPeople == 0) {
                return 0; // No people, no umbrellas needed
            }
            if (result[numOfPeople] != -1) {
                System.out.println("    Memoized result - numOfPeople: " + numOfPeople + ", result: " + result[numOfPeople]);
                return result[numOfPeople]; // Return cached result
            }

            int minUmbrellasNeeded = Integer.MAX_VALUE;
            for (int uSize : umbrellaSizes) {
                if (uSize <= numOfPeople) {
                    int remainingPeople = numOfPeople - uSize;
                    int umbrellasNeeded = 1 + minUmbrellasRecursive(remainingPeople, umbrellaSizes, result);
                    System.out.println("            Calculated result - numOfPeople: " + numOfPeople + ", result: min of " + umbrellasNeeded+ " or "+minUmbrellasNeeded);
                    minUmbrellasNeeded = Math.min(minUmbrellasNeeded, umbrellasNeeded);
                }
            }

            if (minUmbrellasNeeded == Integer.MAX_VALUE) {
                System.out.println("#Impossible case - numOfPeople: " + numOfPeople + ", result: " + minUmbrellasNeeded);
                result[numOfPeople] = -1; // impossible case
                return -1;
            }

            result[numOfPeople] = minUmbrellasNeeded; // Store result in result
            System.out.println("New Stored result - numOfPeople: " + numOfPeople + ", result: " + result[numOfPeople]);
            return minUmbrellasNeeded;
        }

        public static void main(String[] args) {
            int numPeople1 = 3;
            int[] umbrellaSizes1 = {1, 2};
            System.out.println("========== Minimum umbrellas for " + numPeople1 + " people: " + minUmbrellas(numPeople1, umbrellaSizes1)); // Output: 2

            int numPeople2 = 10;
            int[] umbrellaSizes2 = {3, 1};
            System.out.println("========== Minimum umbrellas for " + numPeople2 + " people: " + minUmbrellas(numPeople2, umbrellaSizes2)); // Output: 4

            int numPeople3 = 3;
            int[] umbrellaSizes3 = {2};
            System.out.println("========== Minimum umbrellas for " + numPeople3 + " people: " + minUmbrellas(numPeople3, umbrellaSizes3)); // Output: -1
        }
    }


