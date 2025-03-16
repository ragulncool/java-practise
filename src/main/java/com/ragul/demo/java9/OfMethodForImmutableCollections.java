package com.ragul.demo.java9;

import java.util.List;
import java.util.Map;

public class OfMethodForImmutableCollections {
    //Empty List example:
    List immutableList = List.of();

    //Non-Empty List example:
    List list2 = List.of("one", "two", "three");

   // Empty Map Example:
    Map emptyImmutableMap = Map.of();

    //Non-Empty Map Example:
    Map nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");

    //we cannot put data into immutable map or list

}
