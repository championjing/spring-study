package com.example.myautoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//第一步，加入@EnableAutoConfiguration
@EnableAutoConfiguration
public class FirstAppByGuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppByGuiApplication.class, args);
    }

}
