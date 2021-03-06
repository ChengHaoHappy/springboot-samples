package com.springboot.oauth2demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：HappyCheng
 * @date ：2019/10/29
 */
@RestController
public class HelloController {

    @GetMapping("/admin/hello")
    public String admin(){
        return "Hello admin";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "Hello User";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
