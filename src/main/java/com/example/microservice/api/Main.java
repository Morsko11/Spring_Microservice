package com.example.microservice.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.microservice");
        RestApi bean = applicationContext.getBean(RestApi.class);
        System.out.println( bean.getAvg());
    }
}
