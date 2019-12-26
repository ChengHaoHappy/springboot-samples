package com.springboot.security02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContext;

@SpringBootApplication
@MapperScan("com.springboot.security02.mapper")
public class Security02Application {

    public static void main(String[] args) {
        SpringApplication.run(Security02Application.class, args);


    }

}
