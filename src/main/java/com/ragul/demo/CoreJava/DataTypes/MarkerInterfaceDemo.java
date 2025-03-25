package com.ragul.demo.CoreJava.DataTypes;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//if implements is missed, CloneNotSupportedException is thrown in runtime
public class MarkerInterfaceDemo  {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        ClassUsingMarkerInterface obj = new ClassUsingMarkerInterface();
        ClassUsingMarkerInterface obj1 = (ClassUsingMarkerInterface) obj.clone();

    }
}

 class ClassUsingMarkerInterface implements Cloneable {

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}