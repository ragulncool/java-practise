package com.ragul.demo.java9;

import java.util.List;
import java.util.Map;

public class OfMethodForImmutableCollections {



    public static void main(String[] args) {
        //Empty List example:
        List immutableList = List.of();

        //Non-Empty List example: //null cannot be added in immutable list
        List list2 = List.of("one", "two", "three");

        // Empty Map Example:
        Map emptyImmutableMap = Map.of();

        //Non-Empty Map Example:
        Map nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");

        //we cannot put data into immutable map or list

        //LIMITATION - Immutable list cannot be midified
        //throws UnsupportedOperationException
        list2.add("four");
        list2.remove("one");
    }
}
