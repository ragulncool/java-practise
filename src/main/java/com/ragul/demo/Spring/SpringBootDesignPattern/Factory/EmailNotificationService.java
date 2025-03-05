package com.ragul.demo.Spring.SpringBootDesignPattern.Factory;

//@Component
public class EmailNotificationService implements NotificationService{

    public void notify(String message) {
      System.out.println("Email Notification");
    }

}

