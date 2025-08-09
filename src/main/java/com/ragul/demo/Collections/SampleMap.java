package com.ragul.demo.Collections;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SampleMap {
    //Array vs Map
    //If we use, searching [since we search every index] and deleting O(n)
    //while O(1) in map since we check key, insert and delete also O(1)


    public static void main(String args[]){
        Map<String,String> map = new HashMap<>();
        map.put("one","SAMPLE1");
        map.put("com.ragul.demo.problems.two","SAMPLE12");

        System.out.println(map.keySet()); //Set of keys
        System.out.println(map.values());//Set of values
        System.out.println(map.entrySet()); //Set of keys and values
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsValue("SAMPLE1"));
        Map<String,String> map1 = new HashMap<>();
        map1.putAll(map);

        map.clear();
        map.size();

        Map<String, Integer> counts = new HashMap<>();
        counts.put("apple", 1);
        counts.put("banana", 1);

        //methods to reduce code duplication
        counts.putIfAbsent("google", 2); // adds "google" with value 10 if not present
        counts.getOrDefault("google", 0); // returns 0 if key not found
        counts.put("google",counts.getOrDefault("google", 0)+1);

        // Add a new entry
        //Both achieve the same result here, but merge is more flexible for complex merging logic.
        counts.merge("orange", 1, (oldValue, newValue) -> oldValue + newValue);
        //alternative way to add new entry
        counts.put("orange", counts.getOrDefault("orange", 0) + 1);

        System.out.println("After adding orange: " + counts); // {apple=5, banana=3, orange=2}

        // Update an existing entry by summing values
        counts.merge("apple", 3, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("After merging apple: " + counts); // {apple=8, banana=3, orange=2}

        //----------------
        //Map.Entry is like int - it is a single key-value pair
        //can add one entry or delete
        Map.Entry<Integer,Integer> entry = new AbstractMap.SimpleEntry<>(1, 2);
entry.setValue(3);
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());




    }
}
