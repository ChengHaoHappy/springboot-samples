package com.ws.chapter0701;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:实体类
 * @author: chenghao
 * @date: 2019/8/20
 */
@Entity(name = "t_book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
}
