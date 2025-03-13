package com.ragul.demo.Multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsConcurrentHashMap {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        for(Integer key:map.keySet()){
            map.put(1,3);//No Exception
            //map.remove(1); //ConcurrentModificationException - when something we are iterating on is modified
        }

        //SOLUTION 1 - SAFE MODIFICATION
        for(Integer key:map.keySet()){
            if(key!=1){
                map.remove(1); //iterating is not modified - safe modification
            }
        }
        map.keySet().stream().forEach(x->System.out.println(x+" "+map.get(x)));

        //SOLUTION 2 - Use ConcurrentHashMap
        Map<Integer,Integer> cMap = new ConcurrentHashMap<>();
        cMap.put(11,11);
        cMap.put(12,12);
        for(Integer key:cMap.keySet()){
            cMap.put(11,13);
            cMap.remove(11); //No ConcurrentModificationException
        }
        cMap.keySet().stream().forEach(x->System.out.println(x+" "+cMap.get(x)));

    }

   // ConcurrentHashMap is a thread-safe collection.
    // That is, multiple threads can access and modify it at the same time.

//    The ConcurrentHashMap class allows multiple threads to access its entries concurrently.
//    By default, the concurrent hashmap is divided into 16 segments.
//    This is the reason why 16 threads are allowed to concurrently modify the map at the same time.
//    However, any number of threads can access the map at a time.

}
