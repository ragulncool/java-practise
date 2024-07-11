package com.ragul.demo.problems;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class uniqueRowsInMatrix {
    public static void main(String args[]){
        int[][] num= {{1,1,0,0,1},{0,1,0,1,1},{1,1,1,0,1},{1,1,0,0,1},{1,1,1,1,1}};
        Set<String> rowString = new HashSet<>();

        for(int i=0;i<num.length;i++){
            String row="";
           // StringBuilder row = new StringBuilder(""); //will not work since equals in string builder does reference comparision
            for(int j=0;j<num.length;j++){
               row =   row.concat(String.valueOf(num[i][j])); //since String is immutable
            }
            rowString.add(row); //equals in string does content comparsion
        }
        System.out.println(rowString);
    }
}
