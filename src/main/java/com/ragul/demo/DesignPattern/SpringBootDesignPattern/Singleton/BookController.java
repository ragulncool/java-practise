package com.ragul.demo.DesignPattern.SpringBootDesignPattern.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/count1")
    public String findCount() {
        System.out.println(bookRepository);
        return "count1";
    }
}