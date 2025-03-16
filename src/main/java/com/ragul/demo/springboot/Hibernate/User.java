package com.ragul.demo.springboot.Hibernate;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="user")
public class User {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private int id;

    @Column
    private String username;

//    @manytomany(cascade=cascadetype.all)
//    @jointable(name="usr_vehicle",joincolumns=@joincolumn(name="user_id"),inversejoincolumns=@joincolumn(name="vehicle_id") )
//    private collection<vehicle> vehicle=new arraylist<>();
//
//    @onetoone(cascade=cascadetype.all)
//    @joincolumn(name="address_id")
//    private address address;
//
//    @onetomany(cascade=cascadetype.all)
//    @jointable(name="user_mobile_mapping",joincolumns=@joincolumn(name="user_id"),inversejoincolumns=@joincolumn(name="mobile_id"))
//    private collection<mobile> mobile=new arraylist<>();;


}