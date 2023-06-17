package ru.nastia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);

        TestBean user = ctx.getBean(TestBean.class);
        user.hello();
    }
}
