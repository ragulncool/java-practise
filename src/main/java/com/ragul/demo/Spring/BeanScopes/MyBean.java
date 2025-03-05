package com.ragul.demo.Spring.BeanScopes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class MyBean {

    public MyBean() {
        System.out.println("MyBean instance created");
    }

}

@Configuration
 class ScopeConfiguration {

    @Bean
 // SCOPE 1 -   @Scope(value="singleton") - this will be taken as default if no scope is specified
   // SCOPE 2
    @Scope(value="prototype")
    //SCOPE 3,4,5 - @Scope("request") or any 3 will cause error
    //request, session and global-session scopes are not available for standalone applications.
    public MyBean myBean() {
        return new MyBean();
    }

}


class MySpringApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeConfiguration.class);
        ctx.refresh();

        MyBean mb1 = ctx.getBean(MyBean.class);
        System.out.println(mb1.hashCode());

        MyBean mb2 = ctx.getBean(MyBean.class);
        System.out.println(mb2.hashCode());

        ctx.close();
    }

    //Singleton - MyBean instances have same hashcode and the constructor is called once once, it means that spring container is returning the same instance of MyBean always.

}