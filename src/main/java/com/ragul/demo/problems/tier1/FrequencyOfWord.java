package com.ragul.demo.problems.tier1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfWord {
    public static void main(String[] args) {
        String text = "java spring java kafka spring java";
        String[] textArr = text.split("\\s+"); //s-whitespace,+ - one or more

        Map<String,Long> freq = Arrays.stream(textArr).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
         //usually listObj.stream
        //here Arrays.stream(arr)

        System.out.println(freq);

    }
}
