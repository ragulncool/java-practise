package com.ragul.demo.springboot.Hibernate;

import jakarta.persistence.*;
import lombok.Data;

//@Entity
@Data
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String street;

    private String city;

 //   @OneToOne(mappedBy = "Adde")
    private User user;

    public Address() {}
    public Address(int id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }


}