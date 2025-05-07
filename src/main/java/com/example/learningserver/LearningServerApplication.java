package com.example.learningserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.example")
public class LearningServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningServerApplication.class, args);
    }

}
