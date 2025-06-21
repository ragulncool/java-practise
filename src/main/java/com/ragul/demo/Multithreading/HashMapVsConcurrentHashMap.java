package com.ragul.demo.Multithreading;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsConcurrentHashMap {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(11, 11);
        map.put(12, 12);

        for (Integer key : map.keySet()) {
            map.put(11, 3);//No Exception
            map.remove(11); //ConcurrentModificationException - when something we are iterating on is modified
        }

        //SOLUTION 1 - SAFE MODIFICATION
        for (Integer key : map.keySet()) {
            if (key != 1) {
                map.remove(1); //iterating is not modified - safe modification
            }
        }
        map.keySet().stream().forEach(x -> System.out.print(x + " " + map.get(x)+"   "));
        System.out.println();

        //SOLUTION 2 - Use ConcurrentHashMap - uses segment level lock for better concurrency
        Map<Integer, Integer> cMap = new ConcurrentHashMap<>();
        cMap.put(11, 11);
        cMap.put(12, 12);
        for (Integer key : cMap.keySet()) {
            cMap.put(11, 13);
            cMap.remove(11); //No ConcurrentModificationException
        }
        cMap.keySet().stream().forEach(x -> System.out.println(x + " " + cMap.get(x)));

        Map<Integer, Integer> cMap1 = new ConcurrentHashMap<>();
        cMap1.put(11, 11);
        cMap1.put(12, 12);
        for (Integer key : cMap.keySet()) {
           if( key != 11) {
                cMap1.remove(11); //iterating is not modified - safe modification
            }
        }
        cMap1.keySet().stream().forEach(x -> System.out.println(x + " " + cMap.get(x)));


    }
}

   // ConcurrentHashMap is a thread-safe collection.
    // That is, multiple threads can access and modify it at the same time.

//    The ConcurrentHashMap class allows multiple threads to access its entries concurrently.
//    By default, the concurrent hashmap is divided into 16 segments.
//    This is the reason why 16 threads are allowe