package com.ragul.demo.CoreJava.DataTypes;

public class LoopsBasics {
    //using == doesnt terminate, for safer side, use >= for terminating condition

    public static void main1(String args[]) {
        //exiting from loops
        int count1 = 0;
        while (true) {
            count1++;
            System.out.println(count1);
            if (count1 == 10) {
                  // return; - will throw error since code after loop will execute
                    break; //will terminate only loop but code after loop is executed
            }
        }
        System.out.println("Code after loop is executed");

    }

    public static void main(String args[]) {
        //exiting from loops
        int count1 = 0;
        int count2 = 100;
        while (true) {
            while (true) {
                count1++;
                System.out.println(count1);
                if (count1 >= 10) {
                    // return; - will throw error since code after loop will execute
                    break; //will terminate only loop but code after loop is executed
                    //will terminate only inner loop
                }
            }
            count2++;
            System.out.println(count2);
            if (count2 >= 110) {
                break;
            }
        }
        //System.out.println("Code after loop is executed");

    }
}
