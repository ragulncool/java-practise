package com.ragul.demo.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//The name reflection is used to describe code which is able to inspect other code in the same system (or itself).

//Reflection is a language's ability to inspect and dynamically call classes, methods, attributes, etc. at runtime.
public class Reflection {
    public static void main(String args[]) throws ClassNotFoundException {
        System.out.println("===PERSON CLASS===");
        Object person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());

        System.out.println(fieldNames.toString());


        System.out.println("===ARRAYLIST===");
        Class object = Class.forName("java.util.ArrayList");
        Method[] methods = object.getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method.getName());

    }
}
