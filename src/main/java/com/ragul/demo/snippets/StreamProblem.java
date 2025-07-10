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


        System.out.println("AVERAGE " + list1.stream().filter(x->x%2==0).mapToInt(x->x).average());
        System.out.println("SUM " + list1.stream().filter(x->x%2==0).mapToInt(x->x).sum());
        System.out.println("SUM " + list1.stream().filter(x->x%2==0).mapToInt(Integer::intValue).sum()); //two sum methods one from int and other from Integer

        System.out.println("MIN " + list1.stream().filter(x->x%2==0).mapToInt(x->x).min());
        System.out.println("MAX " + (list1.stream().filter(x->x%2==0).mapToInt(x->x).max()).getAsInt());

        //Integer methods returns optional. so at end, use getAsInt() or getAsDouble()


        OptionalDouble a = list1.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average();
        System.out.println("AVERAGE "+a.getAsDouble());

        //sort HashMap with keys and values.
        Map<Integer, String> map = Map.of(3, "three", 1, "one", 2, "two");
        map.entrySet().stream().sorted(Comparator.comparingInt(x-> x.getKey())).toList();
        System.out.println(map);

        System.out.println("GROUP STRING BY FIRST CHARAC");
        List<String> list2 = List.of("apple", "banana", "cherry", "date","carrot");
        Map<Character,List<String>> mapGroup = list2.stream().collect(Collectors.groupingBy(x->x.charAt(0))); //using groupingBy
      //  Map<Character,String> mapGroup1 = list2.stream().collect(Collectors.toMap(x->x.charAt(0),x->x)); //ERROR - Duplicate key (attempted merging values x and x)
        Map<Character,String> mapGroup2 = list2.stream().collect(Collectors.toMap(x->x.charAt(0),x->x, (x,y)->x+","+y)); //using toMap - added combine duplicates
        System.out.println(mapGroup);
        System.out.println(mapGroup2);


        // If keys contains strings starts with uppercase letters.x


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

      // Given a list of integers, write a Java 8 stream to find the sum of all numbers in the list that are divisible by 3.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       int sum = numbers.stream()
                .filter(n -> n % 3 == 0)
                .mapToInt(Integer::intValue)
                .sum();
       System.out.println(sum);

        //Given a list of strings, write a Java 8 stream to find the average length of all strings in the list.
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        double averageLength = strings.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        double averageLength1 = strings.stream()
                .map(x->x.length())
                .mapToInt(x->x)
                .average()
                .orElse(0.0);
        System.out.println(averageLength);
        System.out.println(averageLength1);

        //Given a list of strings, write a Java 8 stream to find the length of the longest string in the list.
        int longestLen = strings.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
       System.out.println(longestLen);
        strings.stream().map(x->x.length()).mapToInt(x->x).max().ifPresent(System.out::println);

        //Given a list of strings, write a Java 8 stream to find the number of strings in the list that start with the letter “a”.
        long count = strings.stream()
                .filter(s -> s.startsWith("a"))
                .count();

        System.out.println(count);

        //write a Java 8 stream to find the number of strings in the list that have a length of 5.
        long count1 = strings.stream()
                .filter(s -> s.length() == 5)
                .count();

//, write a Java 8 stream to find the second highest number in the list
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int secondHighest = numbers1.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(-1); // or any default value
        System.out.println(secondHighest);

//        write a Java 8 stream to find the sum of all numbers greater than 5
        int sum1 = numbers1.stream()
                .filter(n -> n > 5)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum1);

//write a Java 8 stream to find the product of all numbers in the list.
        int product = numbers1.stream()
                .reduce(1, (x, y) -> x * y); //1 is initial value
        System.out.println(product);


//        write a Java 8 stream to find the distinct strings in the list.
        List<String> distinctStrings = strings.stream()
                .distinct()
                .collect(Collectors.toList());

//        write a Java 8 stream to find the number of vowels in all strings in the list.

        long vowelCount = strings.stream()
                .flatMapToInt(String::chars)
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .count();
        System.out.println(vowelCount);

        //write a Java 8 stream to find the number of distinct vowels in all strings in the list.
        Set<Character> distinctVowels = strings.stream()
                .flatMapToInt(String::chars)
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

//        write a Java 8 stream to find the sum of the squares of all numbers in the list.
        int sumOfSquares = numbers1.stream()
                .mapToInt(n -> n * n)
                .sum();
        System.out.println(sumOfSquares);

//        write a Java 8 stream to find the number of strings in the list that contain the substring “the”
        long countSubstring = strings.stream()
                .filter(s -> s.contains("the"))
                .count();
        System.out.println(countSubstring);

//        , write a Java 8 stream to find the difference between the maximum and minimum numbers in the list.
        int max = numbers1.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        int min = numbers1.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
        int difference = max - min;
        System.out.println(difference);

//        write a Java 8 stream to find the number of strings in the list that have at least one uppercase letter
        long countUppercase = strings.stream()
                .filter(s -> s.chars().anyMatch(Character::isUpperCase))
                .count();
        System.out.println(countUppercase);

        //write a Java 8 stream to find the sum of all numbers that are both even and divisible by 3.
        int sumEvenDivisibleBy3 = numbers1.stream()
                .filter(n -> n % 2 == 0 && n % 3 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        //write a Java 8 stream to find the number of distinct prime numbers in the list.
        long countDistinctPrimes = numbers1.stream()
                .filter(n -> isPrime(n)) //prime - not divisible by 2 to square root of n
                .distinct()
                .count();

        System.out.println(countDistinctPrimes);


    }

    private static boolean isPrime(Integer n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
