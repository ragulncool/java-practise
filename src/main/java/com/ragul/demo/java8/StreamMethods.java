package com.ragul.demo.java8;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMethods {

    public static void main(String[] args) {

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