package com.ragul.demo.Collections;

import java.util.ArrayList;
import java.util.List;

public class PassByValue {

        public static void main(String[] args)
        {
            Add obj = new Add(5, 10);
            int z=0;
            // call by value (object is passed)
            change(obj.x,obj.y,z);
            System.out.println("x = "+obj.x);
            System.out.println("y = "+obj.y);
            System.out.println("z = "+z); //value not chaanged to 1 since pass by value

            change(obj); //achiveing pass by reference in java - pass entire object instead of param or var
            System.out.println("x = "+obj.x);
            System.out.println("y = "+obj.y);

            int[] arr=new int[5];
            changeArray(arr); //achiveing pass by reference in java - pass entire object instead of param or var
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }

            List<Integer> list = new ArrayList<>();
            changeList(list); //achiveing pass by reference in java - pass entire object instead of param or var
            System.out.print(list);


        }

    private static void changeList(List<Integer> list) {
            list.add(123);
    }

    private static void changeArray(int[] arr) {
            arr[0]=1;
            arr[1]=2;
    }


    public static void change(int x, int y, int z)
    {
        x++;
        y++;
        z=z+1;
    }

    public static void change(Add a)
    {
        a.x++;
        a.y++;
    }
}
class Add
{
    int x, y;
    Add(int i, int j)
    {
        x = i;
        y = j;
    }
}