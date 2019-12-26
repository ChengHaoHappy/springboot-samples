package com.ws.chapter0701;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/9/3
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

}
