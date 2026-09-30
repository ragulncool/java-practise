package com.ragul.demo.Spring.JavaDesignPatterns.Factory;

public class TestFactory {
    public static void main(String[] args) {
        Notification notification;

        notification = NotificationFactory.createNotification("sms");
        notification.notifyUser();  // Sending an SMS notification

        notification = NotificationFactory.createNotification("email");
        notification.notifyUser();  // Sending an Email notification

        notification = NotificationFactory.createNotification("push");
        notification.notifyUser();  // Sending a Push notification
    }
}

 class NotificationFactory {

    // Factory method
    public static Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }

        switch (type.toLowerCase()) {
            case "sms":
                return new SMSNotification();
            case "email":
                return new EmailNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}


 interface Notification {
    void notifyUser();
}

 class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

 class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email notification");
    }
}

 class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push notification");
    }
}
