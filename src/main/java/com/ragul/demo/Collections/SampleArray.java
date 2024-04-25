package com.ragul.demo.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleArray {
    public static void main(String args[]){

        char c[]= { 'd','b','c' };
        char d[]= { 'a','b','c' };

        //MOST USED
        System.out.println(c[0]);
        System.out.println(c.length);
        Arrays.sort(c);      System.out.println(c);//affects original array
        System.out.println(Arrays.equals(c,d));
        List<Integer> a = Arrays.asList();

        //LEAST USED
        System.out.println(Arrays.compare(c,d));
        Arrays.fill(d,'e');         System.out.println(d); //fill all indexes with the element
        System.out.println(Arrays.binarySearch(c,'a'));






//        List<String> list1=new ArrayList<>();
//        list1.addAll(list);
//    //   list.add("sample"); ERROR CANNOT ADD
//        list1.add("sample");
//        list1.get(0);
//        list.size();
//        list1.addAll(list);
//        System.out.println(list1.containsAll(list));
//        System.out.println(list.contains("A"));
//        System.out.println(list.subList(1,2)); //start index, endindex-1
//        System.out.println(list1);
//        //returns index of last occurence of the object
//        System.out.println(list1.lastIndexOf("sample")); //-1 if not exist
//
//       // list.clear(); ERROR CANNOR CLEAR
//        list1.clear();
    }
}
