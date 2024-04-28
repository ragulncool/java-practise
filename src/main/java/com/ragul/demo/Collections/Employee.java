package com.ragul.demo.Collections;

import lombok.Data;

import java.util.Objects;

@Data
public class Employee {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int id;

    private String name;

    private String address;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return this.name.equals(employee.name);
//    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        boolean result = Objects.equals(this.name, employee.name);
        System.out.println("equals result : "+result);
        return result;
    }

    @Override
    public int hashCode() {
        int hashCode = Objects.hash(name);
        System.out.println("hashCode result : "+hashCode);
        return hashCode;

//        int hashcode = 0;
//                System.out.println("hashCode result : "+hashcode);
//        return hashcode;
    }

    public Employee(int id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address=address;
    }


}
