package com.wangsong.springboot.chapter04.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/18
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @PostMapping("/")
//    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String addBook(String name) {
        return "receive" + name;
    }

    @DeleteMapping("/{id}")
//    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }
}
