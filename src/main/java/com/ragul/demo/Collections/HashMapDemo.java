package com.ragul.demo.Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String args[]){
        Map<String,String> map = new HashMap<>();
        map.put("one","two");

        for(Map.Entry<String, String> d:map.entrySet()){
            map.put("two","two");
        }
    }
}
