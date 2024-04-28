package com.ragul.demo.Collections;

public class StaticAndIntializerblock {

    static{
        System.out.println("Inside static");
    }

    { //will not be printed. no instance created
        System.out.println("Inside  initializer");
    }

    public StaticAndIntializerblock(){ //will not be printed. no instance created
        System.out.println("Inside Constructor");
    }


    public static void main(String args[]){
        System.out.println("Inside main");
    }
}

class StaticAndInitialzationChild{
    static{  //1  ALWAYS EXECUTED BEFORE MAIN METHOD
        System.out.println("Inside class2 static");
    }
    {  //2 EXECUTED FIORST BEFORE CONSTRUCTOR WHEN INSTANCE IS CREATED
        System.out.println("Inside class2 initializer");
    }

    public StaticAndInitialzationChild(){ //3
        System.out.println("Inside class2 Constructor");
    }

    public static void main(String args[]){
        StaticAndInitialzationChild s=new StaticAndInitialzationChild();  //change order of this line and check
        System.out.println("Inside class2 main");

      //  StaticAndInitialzationChild s=new StaticAndInitialzationChild();

    }
}
