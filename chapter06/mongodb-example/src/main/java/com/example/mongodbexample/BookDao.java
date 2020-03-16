package com.example.mongodbexample;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created By ChengHao On 2020/3/16
 */
public interface BookDao extends MongoRepository<Book, Integer> {
    List<Book> findByAuthorContains(String author);

    Book findByNameEquals(String name);
}
