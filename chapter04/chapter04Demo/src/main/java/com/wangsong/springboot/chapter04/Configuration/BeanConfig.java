package com.wangsong.springboot.chapter04.Configuration;

import com.wangsong.springboot.chapter04.Bean.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/18
 */
@Configuration
public class BeanConfig {

    @Bean
    public Book book() {
        return new Book();
    }
}
