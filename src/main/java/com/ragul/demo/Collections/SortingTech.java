package com.ragul.demo.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingTech {
    public static void main(String args[]){
        Employee e1=new Employee(1,"one","address1");
        Employee e2=new Employee(2,"two","address2");
        Employee e3=new Employee(3,"three","address3");

        List<Employee> list=new ArrayList<>();
        list.add(e3);
        list.add(e1);
        list.add(e2);
        System.out.println(list);

        //Collections.sort(list)-Compile error ;//or streams sorted() gives run time error //- reason: no instance(s) of type variable(s) T exist so that Employee conforms to Comparable<? super T>

      //  4 WAYS - USING CUSTOM COMPARATOR AND INBUILT COMPARATOR
//        Collections.sort(list, new EmployeeComparator());
//        System.out.println(list);

//        List<Employee> list1= list.stream().sorted(new EmployeeComparator()).collect(Collectors.toList());
//        System.out.println(list1);

//        List<Employee> list2= list.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
//        System.out.println(list2);

        Collections.sort(list,Comparator.comparingInt(Employee::getId));
        System.out.println(list);
    }
}

class EmployeeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId()-o2.getId();
    }
}
