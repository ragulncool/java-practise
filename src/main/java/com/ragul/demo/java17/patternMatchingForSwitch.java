package com.ragul.demo.java17;
// Java 17 introduces pattern matching for switch statements, which simplifies code by combining the declaration of a variable with its conditional check
public class patternMatchingForSwitch {

    public static void main(String[] args) {
        int day=3;
        String dayOfWeek = switch (day) {

//            case 1 :
//                dayOfWeek = "Monday";
//                break;

            case 2 -> "Tuesday";

            case 3 -> "Wednesday";

            case 4 -> "Thursday";

            case 5 -> "Friday";

            default -> "Unknown";

        };

        System.out.println(dayOfWeek);
    }

}
