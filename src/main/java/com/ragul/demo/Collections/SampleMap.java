package com.ragul.demo.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SampleMap {
    public static void main(String args[]){
        Map<String,String> map = new HashMap<>();
        map.put("one","SAMPLE1");
        map.put("two","SAMPLE12");

        System.out.println(map.keySet()); //Set of keys
        System.out.println(map.values());//Set of values
        System.out.println(map.entrySet()); //Set of keys and values
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsValue("SAMPLE1"));
        Map<String,String> map1 = new HashMap<>();
        map1.putAll(map);

        map.clear();
        map.size();
    }
}
