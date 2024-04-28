package com.ragul.demo.Collections;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SampleMap {
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


    }
}
