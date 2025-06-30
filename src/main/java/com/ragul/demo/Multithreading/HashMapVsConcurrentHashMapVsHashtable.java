package com.ragul.demo.Multithreading;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsConcurrentHashMapVsHashtable {

    // HashMap  SINGLE THREADED ENV - is not synchronized, meaning it is not thread-safe - used in single-threaded applications or when external synchronization is applied.
    //ConcurrentHashMap - MULTI THREADED ENV.  is a thread-safe variant of HashMap, allowing concurrent access by multiple threads without external synchronization.
   //HashTable - RARELY USED. is synchronized, meaning it is thread-safe, but it is generally slower than ConcurrentHashMap due to its locking mechanism.
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(11, 11);
        map.put(12, 12);

        for (Integer key : map.keySet()) {
            map.put(11, 3);//No Exception
            //map.remove(11); //ConcurrentModificationException - when something we are iterating on is modified
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

       //SOLUTION 3 - Use Hashtable - synchronized collection  - AVOIDED NOW AND USING CONCURRENTHASHMAP
        Hashtable <Integer, Integer> hTable = new Hashtable<>();
        hTable.put(11, 11);
        hTable.put(12, 12);
        for (Integer key : hTable.keySet()) {
            if( key == 11) {
                hTable.remove(11);
            }
        }

        //Solution 4 - Use Collections.synchronizedMap() to wrap a HashMap - NOT WORKING - EXPECTED: EXCEPTION SHOULD NOT THROW BUT THROWN
//        Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
//        synchronizedMap.put(11, 11);
//        synchronizedMap.put(12, 12);
//        synchronized (synchronizedMap) { //need to synchronize the block to avoid ConcurrentModificationException
//            for (Integer key : synchronizedMap.keySet()) {
//                synchronizedMap.put(11, 14);
//                synchronizedMap.remove(11); //No ConcurrentModificationException
//            }
//        }

    }
}

   // ConcurrentHashMap is a thread-safe collection.
    // That is, multiple threads can access and modify it at the same time.

//    The ConcurrentHashMap class allows multiple threads to access its entries concurrently.
//    By default, the concurrent hashmap is divided into 16 segments.
//    This is the reason why 16 threads are allowe