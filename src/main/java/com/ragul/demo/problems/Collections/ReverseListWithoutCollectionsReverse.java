package com.ragul.demo.problems.Collections;

import java.util.List;

public class ReverseListWithoutCollectionsReverse {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
       for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        // Output: 9 8 7 6 5 4 3 2 1

    }
}
