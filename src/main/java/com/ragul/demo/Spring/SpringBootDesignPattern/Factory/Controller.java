package com.ragul.demo.Spring.SpringBootDesignPattern.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/factory")
    public void findCount() {
        notificationService.notify("hello");
    }
}