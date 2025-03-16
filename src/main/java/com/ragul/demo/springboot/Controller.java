package com.ragul.demo.springboot;

import com.ragul.demo.springboot.Hibernate.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Controller {

    @Autowired
    ASyncService service;

    @Autowired
    DBRepository dbRepository;

     @GetMapping
     List<Address> find(){
         return dbRepository.findAll();
     }
}