package com.chapter10.security03.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By ChengHao On 2019/11/17
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
