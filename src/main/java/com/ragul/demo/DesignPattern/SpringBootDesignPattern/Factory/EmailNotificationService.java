package com.ragul.demo.DesignPattern.SpringBootDesignPattern.Factory;

//@Component
public class EmailNotificationService implements NotificationService{

    public void notify(String message) {
      System.out.println("Email Notification");
    }

}

