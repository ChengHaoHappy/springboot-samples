package com.wnagsong.springboot.chapter02.Controller;

import com.wnagsong.springboot.chapter02.Bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/16
 */
@RestController
public class HelloController {

    @Autowired
    Book book;

    @GetMapping("/book")
    public String book() {
        return book.toString();
    }

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }


}
