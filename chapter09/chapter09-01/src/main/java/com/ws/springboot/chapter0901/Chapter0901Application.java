package com.ws.springboot.chapter0901;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Chapter0901Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter0901Application.class, args);
    }

}
