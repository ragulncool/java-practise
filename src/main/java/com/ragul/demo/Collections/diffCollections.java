package com.ragul.demo.Collections;

import java.util.*;

//array, linked - insertion order
//tree- asc
//hash - any order

public class diffCollections {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        System.out.println("ArrayList : "+list); //insertion order

        List<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(1);
        list1.add(2);
        System.out.println("LinkedList : "+list1); //insertion order

        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(2);
        System.out.println("HashSet : "+set);//unpredictable order

        Set<Integer> set1 = new LinkedHashSet<>();
        set1.add(3);
        set1.add(1);
        set1.add(2);
        set1.add(2);
        System.out.println("LinkedHashSet : "+set1); //insertion order

        Set<Integer> set2 = new TreeSet<>();
        set2.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(2);
        System.out.println("TreeSet : "+set2); //sorted

        Map<Integer,String> map=new HashMap<>();
        map.put(3,"three");
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,null);
        map.put(null,null);
        System.out.println("HashMap : "+map); //unpredictable order

        Map<Integer,String> map1=new LinkedHashMap<>();
        map1.put(3,"three");
        map1.put(1,"one");
        map1.put(2,"two");
        map1.put(3,null);
        map1.put(null,null);
        System.out.println("LinkedHashMap : "+map1); //insertion order

        Map<Integer,String> map2=new TreeMap<>();
        map2.put(3,"three");
        map2.put(1,"one");
        map2.put(2,"two");
        map2.put(3,null);
        //map2.put(null,null); Null pointer - TreeMap doesnt allow null key
        System.out.println("TreeMap : "+map2); //sorted
    }
    }
