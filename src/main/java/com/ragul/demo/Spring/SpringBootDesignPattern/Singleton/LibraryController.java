package com.ragul.demo.Spring.SpringBootDesignPattern.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/count2")
    public String findCount() {
        System.out.println(bookRepository);
        return "count2";
    }
}