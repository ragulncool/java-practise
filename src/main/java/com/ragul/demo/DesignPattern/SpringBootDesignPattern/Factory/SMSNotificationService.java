package com.ragul.demo.DesignPattern.SpringBootDesignPattern.Factory;

//@Component
public class SMSNotificationService implements NotificationService {

    public void notify(String message) {
        System.out.println("SMS Notification");
    }

}
