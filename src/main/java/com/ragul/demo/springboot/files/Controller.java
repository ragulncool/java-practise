package com.ragul.demo.springboot.files;

import com.ragul.demo.springboot.files.Hibernate.Address;
import com.ragul.demo.springboot.files.Hibernate.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    ASyncService service;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @PostMapping("post1")
    List<Address> find() {
        System.out.println("Controller method 'find' called");

        Address address = new Address();
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        personRepository.save(person);
        address.setPerson(person);
        address.setId(UUID.randomUUID().toString());
        addressRepository.save(address);
        return addressRepository.findAll();
    }

    @GetMapping("get1")
    List<Address> find1 () {
        return addressRepository.findAll();
    }

    @GetMapping("get2")
    List<Person> find2 () {
        return personRepository.findAll();
    }

    @GetMapping("async")
    void testasync () throws InterruptedException {
        service.processTask();
        service.anotherAsyncTask();
    }
}