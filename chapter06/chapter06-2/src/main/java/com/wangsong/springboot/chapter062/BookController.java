package com.wangsong.springboot.chapter062;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/28
 */
@RestController
public class BookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")   //
    public void testl() {
        ValueOperations<String, String> opsl = stringRedisTemplate.opsForValue();
        opsl.set("name", "sanguo");
        String name = opsl.get("name");
        System.out.println(name);
        ValueOperations ops2 = redisTemplate.opsForValue();  //可以操作对象
        Book book = new Book();
        book.setAuthor("zhangsan");
        book.setName("love");
        ops2.set("bl", book);
        Book book2 = (Book) ops2.get("bl");
        System.out.println(book2);
    }
}