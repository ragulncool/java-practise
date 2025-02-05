package com.ragul.demo.Collections;

import java.util.ArrayList;
import java.util.List;

public class PassByValue2 {

    public static void main(String[] args) {
        int[] arr = new int[1];
        System.out.println("Initial values: "+arr[0]);

        incrementFirstElement(arr);
        System.out.println("After increment: "+arr[0]);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println("Initial values: ");
        list.stream().forEach(System.out::println);

        incrementCollectionElements(list);
        System.out.println("After increment: ");
        list.stream().forEach(System.out::println);
    }

    private static void incrementCollectionElements(List<Integer> list) {
        for (int i=0;i<list.size();i++){
            int updated = list.get(i) + 1;
            list.set(i,updated);
        }
    }

    private static void incrementFirstElement(int[] arr) {
        arr[0]++;
    }
}