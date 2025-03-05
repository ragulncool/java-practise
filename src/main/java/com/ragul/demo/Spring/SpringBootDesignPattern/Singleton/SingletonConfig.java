package com.ragul.demo.Spring.SpringBootDesignPattern.Singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConfig {
    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

}
