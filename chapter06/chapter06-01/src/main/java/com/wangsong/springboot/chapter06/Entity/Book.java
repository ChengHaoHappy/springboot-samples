package com.wangsong.springboot.chapter06.Entity;

import lombok.Data;

;import java.io.Serializable;

/**
 * @description:实体类
 * @author: chenghao
 * @date: 2019/8/20
 */
@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;


}
