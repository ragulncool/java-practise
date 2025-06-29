package com.ragul.demo.snippets;

import java.math.BigDecimal;

public class Confusing {
    public static void main(String[] args) {
        int a=1,b=1;
        System.out.println(a==b);

        Integer a1=1, b1=1;
        System.out.println(a1==b1);

        //IMportant Note: Integer objects are cached for values between -128 and 127 in Java.
        Integer a2=128, b2=128;
        System.out.println(a2==b2); //false, because Integer objects are cached only for values between -128 and 127

        System.out.println(0.1 + 0.2 == 0.3);
        //Floating-point arithmetic is prone to precision errors. 0.1 + 0.2 actually evaluates to 0.30000000000000004, not exactly 0.3

        BigDecimal a3 = new BigDecimal("0.1");
        BigDecimal b3 = new BigDecimal("0.2");
        System.out.println(a3.add(b3).equals(new BigDecimal("0.3")));

        while (true) {
            break;
            //System.out.println("Unreachable"); //ERROR: UNREACHABLE CODE
        }
    }
}
