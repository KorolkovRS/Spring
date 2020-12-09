package ru.korolkovrs.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UI client = context.getBean("consoleClient", ConsoleClient.class);
        client.start();
        context.close();
    }
}

