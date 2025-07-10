package com.ragul.demo.problems.Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class removeDuplicatesInList {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 1, 2, 3, 6);
        //METHOD 1
        Set<Integer> set = new HashSet<>(list); // This will remove duplicates
        List<Integer> uniqueList = new ArrayList<>(set);
        System.out.println(uniqueList);

        //METHOD 2
        List<Integer> uniqueList2 = list.stream()
                .distinct() // This will remove duplicates
                .toList(); // Collect the results into a new List
        System.out.println(uniqueList2);
    }


}
