package com.ragul.demo.Collections;

import lombok.Data;

import java.util.List;

public class Eight {
    public static void main(String args[]){
        List<Nine> nineList = null;

        Nine nine=new Nine();
        nine.setNumber(123);

        nineList.add(nine);

        System.out.println(nineList);

    }
}

@Data
class Nine{
    int number;
}
