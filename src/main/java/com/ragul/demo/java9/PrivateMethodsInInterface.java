package com.ragul.demo.java9;

//added for reusablity by default and static methods
public class PrivateMethodsInInterface {
    private Long createCardID(){  //  -> private methods can be used by default methods within interface
        // Method implementation goes here.
      return 1L;
    }

    private static void displayCardDetails(){  //  -> private static methods can be used by default and static methods within interface
        // Method implementation goes here.
    }
}
