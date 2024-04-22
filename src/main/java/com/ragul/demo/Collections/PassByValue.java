package com.ragul.demo.Collections;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

public class PassByValue {

        public static void main(String[] args)
        {
            Add obj = new Add(5, 10);
            // call by value (object is passed)
            change(obj.x,obj.y);
            System.out.println("x = "+obj.x);
            System.out.println("y = "+obj.y);

            change(obj);
            System.out.println("x = "+obj.x);
            System.out.println("y = "+obj.y);

        }
//        public static void change(Add add)
//        {
//            add.x++;
//            add.y++;
//        }
    public static void change(int x, int y)
    {
        x++;
        y++;
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