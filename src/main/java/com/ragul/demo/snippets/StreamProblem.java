package com.ragul.demo.snippets;

import com.ragul.demo.Collections.Hashing.Employee;

import java.util.*;
import java.util.stream.Collectors;

//Given an Array, remove all odd numbers, multiple each number by a constant and then return sum.
public class StreamProblem {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list = list.stream().filter(x-> x%2==1).map(x->x*2).toList();
        System.out.println(list);

        //return average of even numbers
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list1.stream().filter(x->x%2==0).mapToInt(x->x).average());

        //sort HashMap with keys and values.
        Map<Integer, String> map = Map.of(3, "three", 1, "one", 2, "two");
        map.entrySet().stream().sorted(Comparator.comparingInt(x-> x.getKey())).toList();
        System.out.println(map);

        // If keys contains strings starts with uppercase letters.


       // To find the first non-repeating character

        //Return the list in Integer and in descending order.
         String[] lstOfElemnts = {"1","11","111","1111","13"}; //sorted() for ascending order
        List<Integer> li = Arrays.stream(lstOfElemnts).map(Integer::parseInt).sorted(Comparator.reverseOrder()).toList();
        System.out.println(li);

        //returns list as string
        List<String> cities = Arrays.asList("New York", "London", "Paris", "Tokyo");
        String result = cities.stream().collect(Collectors.joining(", "));
        System.out.println(result);

        //From the given list of cities , print the frequency of occurrence of characters in each word.


     //   print Employee name whose names start with A and lives in Bangalore City using streams API
       //USING DOUBLE FILTER
//        List<String> filteredEmployees = employees.stream()
//                .filter(emp -> emp.getName().startsWith("A"))
//                .filter(emp -> emp.getCity().equalsIgnoreCase("Bangalore"))
//                .map(Employee::getName)
//                .collect(Collectors.toList());
//        filteredEmployees.forEach(System.out::println);

    //    print numeric value from a alphanumeric string?
        String strng = "a1b2c3d4e5f6g7h8i9j0";
        char[] arr= strng.toCharArray();
       for (char c: arr){
           if(Character.isDigit(c)){ //similarly we have Characters.isNumeric
               System.out.print(c);
           }
//           System.out.println();
//           if(Character.isAlphabetic(c)){ //similarly we have Characters.isNumeric
//               System.out.print(c);
//           }
       }
    }




}
