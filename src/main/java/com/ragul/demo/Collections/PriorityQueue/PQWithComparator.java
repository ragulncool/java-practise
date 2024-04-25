package com.ragul.demo.Collections.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQWithComparator {
    public static void main(String args[]){
      //  PriorityQueue<Student> pq=new PriorityQueue<>(); //throws error if entity object is sued and if no comparable

        PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());

        Student s1 = new Student(2,"name1");
        Student s2 = new Student(3,"name2");
        Student s3 = new Student(1,"name3");
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);

        System.out.println(pq);
    }
}

class Student{
    int id;
    String name;

    public Student(int id, String name) {
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "id:"+id+" name:"+name;
    }
}

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {//-1 means lesser, 0 meand equal, 1 means higher
        if(o1.id < o2.id){
            return -1; //change -1 to 1 and vice versa in down for Descending queue
        }else if(o1.id > o2.id){
            return 1;
        }else{
            return 0;
        }
    }
}