package com.ragul.demo.Spring.BeanScopes_6;

import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

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
//   @RequestScope or @Scope(“request”)
//    @SessionScope or @Scope(“session”)
//    @ApplicationScope or @Scope(“application”)
    //SCOPE 3,4,5 - @Scope("request") or any 3 will cause error
    //request, session and global-session scopes are not available for standalone applications.
    //@Scope(scopeName = "websocket",
    //      proxyMode = ScopedProxyMode.TARGET_CLASS)
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