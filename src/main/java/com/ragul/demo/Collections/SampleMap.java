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

        //delete

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = new Date();
        System.out.println(dateFormat.format(date));
//
//        LocalDate lt = LocalDate.parse( date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX"));
//        System.out.println(lt);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        sdf.format(date);
        System.out.println();

    }
}
