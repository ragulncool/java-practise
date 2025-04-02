package com.ragul.demo.Spring.SpringBootDesignPattern.Factory.example2;

    // Interface for notifications
     interface Notification_ {
        void send(String message);
    }

    // Implementation for email notifications
     class EmailNotification implements Notification_ {
        @Override
        public void send(String message) {
            System.out.println("Sending email: " + message);
        }
    }

    // Implementation for SMS notifications
     class SMSNotification implements Notification_ {
        @Override
        public void send(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    // Factory for creating notifications
    public class NotificationFactoryExample2 {
        public Notification_ createNotification(String type) {
            switch (type) {
                case "email":
                    return new EmailNotification();
                case "sms":
                    return new SMSNotification();
                default:
                    throw new IllegalArgumentException("Unknown notification type.");
            }
        }
    }

