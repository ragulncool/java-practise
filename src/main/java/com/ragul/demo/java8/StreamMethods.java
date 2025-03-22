package com.ragul.demo.java8;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMethods {

    public static void main(String[] args) {

        //Intermediate - filter, map, flatMap, distinct, sorted, peek, limit, skip
        //Terminal - collect, forEach, forEachOrdered, toArray, reduce, min, max, count, anyMatch, allMatch, noneMatch, findFirst, findAny

        Order order1 = new Order();
        List<String> items1 = Arrays.asList("bat","bat2");
        List<String> items2 = Arrays.asList("bat","bat2");
        order1.setItems(items1);
        Order order2 = new Order();
        order2.setItems(items2);

        List<Order>orders = Arrays.asList(order1,order2);



        System.out.println(orders);

        List<String> flatMap = orders.stream().flatMap(x->x.getItems().stream()).collect(Collectors.toList());
        System.out.println(flatMap);

        List<Integer>  list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.stream().reduce((a,b)->a+b).ifPresent(System.out::println);
        list.stream().reduce((a,b)->Integer.sum(a,b)).ifPresent(System.out::println);
        list.stream().reduce(Integer::sum).ifPresent(System.out::println);

        List<Integer> page = List.of(10, 20, 30, 40, 50, 60)
                .stream()
                .skip(2) //skips first 2
                .limit(3) //limits to 3
                .collect(Collectors.toList());
        System.out.println(page);

        List<String> list2 = List.of("anand", "bhairav", "cat");
        list2.stream().filter(s -> s.equals("a")).toList(); //toList
        Map<Character, List<String>> grouped = list2.stream().collect(Collectors.groupingBy(s -> s.charAt(0))); //grouping list to Map<Character, List<String>>
        System.out.println(grouped);

        String productList = list2.stream()
                .collect(Collectors.joining(", "));
        System.out.println(productList);

        Optional<String> firstName = List.of("John", "Alex", "Mary").stream().findAny();
        System.out.println(firstName.orElse("No name found")); // Output: Any of above 3

        List<String> names = List.of("John", "Marie", "Ted");
        Optional<String> shortestName = names.stream()
                .min(Comparator.comparingInt(String::length));
        System.out.println(shortestName.orElse("No name found"));

        Optional<String> longestName = names.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println(longestName.orElse("No name found")); // Output: Marie

        boolean hasEven = List.of(1, 2, 3, 4, 5).stream().anyMatch(n -> n % 2 == 0);
        System.out.println(hasEven);

        boolean hasEven1 = List.of(1, 2, 3, 4, 5).stream().allMatch(n -> n % 2 == 0);
        System.out.println(hasEven1); // Output: false

        boolean hasEven2 = List.of(1, 2, 3, 4, 5).stream().noneMatch(n -> n % 2 == 0);
        System.out.println(hasEven2); // Output: false
    }
}

@Getter
@Setter
class Order{
    List<String> items;

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}