package com.ragul.demo.Collections.Sorting;

import com.ragul.demo.Collections.Hashing.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Comparable - compareTo (single sorting seq) - inside pojo class (Employee)
//Comparator - compare (multiple sorting seq) -EmployeeIdAscComparator / name - we can use anyone - seperate class (EmployeeIdAscComparator..)

public class SortingObject {
    public static void main(String args[]){
        Employee e1=new Employee(1,"one","address1");
        Employee e2=new Employee(2,"two","address2");
        Employee e3=new Employee(3,"three","address3");

        List<Employee> list=new ArrayList<>();
        list.add(e3);
        list.add(e1);
        list.add(e2);
        System.out.println(list);

       //Collections.sort(list)
      //  If no compareTO method and class doesnt implement Comparable gives below COmpile error
                //reason: no instance(s) of type variable(s) T exist so that Employee conforms to Comparable<? super T>
                //else srots based on compareTo
        //LIMITATION: Defined inside method. hence only single sorting seq

      //  4 WAYS - USING CUSTOM COMPARATOR AND INBUILT COMPARATOR
//        Collections.sort(list, new EmployeeIdComparator());
//        System.out.println(list);

//        List<Employee> list1= list.stream().sorted(new EmployeeIdAscComparator()).collect(Collectors.toList());
//        System.out.println(list1);

        List<Employee> list1= list.stream().sorted(new EmployeeNameAscComparator()).collect(Collectors.toList());
        System.out.println(list1);

//        List<Employee> list2= list.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
//        System.out.println(list2);

        Collections.sort(list,Comparator.comparingInt(Employee::getId)); //asc
        System.out.println(list);

        //DOUBLE SORTING
        //SORT BY EMPLOYEE ID desc AND EMPLOYEE NAME asc
        Collections.sort(list,Comparator.comparing(Employee::getId).reversed()
                .thenComparing(Employee::getName));
        System.out.println(list);

        //DOUBLE SORT USING SORTED WILL NOT WORK - IT WILL TAKE LAST SORTED
        List<Employee> list2= list.stream().sorted(new EmployeeIdAscComparator())
             //   .sorted(new EmployeeNameAscComparator())
                .collect(Collectors.toList());
        System.out.println(list2);

    }
}

class EmployeeIdAscComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId()-o2.getId();
    }
}

class EmployeeNameAscComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
