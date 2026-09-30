package com.ragul.demo.Spring.JavaDesignPatterns;

public class TestSingl {
    public static void main(String[] args) {
//        Singl s = new Singl();
//        Singl s1= new Singl();

        Singl s2= Singl.getInstance();
        Singl s3 = Singl.getInstance();
        System.out.println(s2);
        System.out.println(s3);
    }
}

class Singl{

    private Singl(){

    }

    static Singl singl = new Singl();

    static Singl getInstance(){
        return singl;
    }

}
