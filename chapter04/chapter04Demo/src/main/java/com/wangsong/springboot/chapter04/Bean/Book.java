package com.wangsong.springboot.chapter04.Bean;

import java.util.Date;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/18
 */
public class Book {
    private String name;
    private String author;
    protected Float price;
    private Date publicationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
