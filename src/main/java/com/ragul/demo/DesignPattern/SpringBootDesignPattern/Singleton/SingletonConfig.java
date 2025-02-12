package com.ragul.demo.DesignPattern.SpringBootDesignPattern.Singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConfig {
    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    //Test in browser
    //http://localhost:8080/count1
    //http://localhost:8080/count2

//    BookRepository objects have the same object ID:
//
//    com.baeldung.spring.patterns.singleton.BookRepository@3ea9524f
//    com.baeldung.spring.patterns.singleton.BookRepository@3ea9524f
//            Copy
//    The BookRepository object IDs in the LibraryController and BookController are the same, proving that Spring injected the same bean into both controllers.
//
//    We can create separate instances of the BookRepository bean by changing the bean scope from singleton to prototype using the @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation.
//
//    Doing so instructs Spring to create separate objects for each of the BookRepository beans it creates. Therefore, if we inspect the object ID of the BookRepository in each of our controllers again, we see that they are no longer the same.
}
