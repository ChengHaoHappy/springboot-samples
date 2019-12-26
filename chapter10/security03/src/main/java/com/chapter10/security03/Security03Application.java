package com.chapter10.security03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启
public class Security03Application {

    public static void main(String[] args) {
        SpringApplication.run(Security03Application.class, args);
    }

}
