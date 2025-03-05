package com.ragul.demo.Spring.SpringBootDesignPattern.Factory;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
    public class NotificationServiceFactory {
    @Bean
    @ConditionalOnProperty(name ="notification.service", havingValue ="email")
    public NotificationService emailNotificationService() {
        return new EmailNotificationService();
    }
    @Bean
    @ConditionalOnProperty (name ="notification. service", havingValue = "sms")
    public NotificationService smsNotificationService() {
        return new SMSNotificationService();
    }
}
