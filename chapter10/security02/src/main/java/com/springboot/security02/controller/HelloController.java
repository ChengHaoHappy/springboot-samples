package com.springboot.security02.controller;

import com.springboot.security02.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }


}
