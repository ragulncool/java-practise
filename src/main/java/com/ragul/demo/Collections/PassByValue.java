package com.ragul.demo.Collections;

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