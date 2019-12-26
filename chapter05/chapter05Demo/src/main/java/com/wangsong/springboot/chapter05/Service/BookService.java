package com.wangsong.springboot.chapter05.Service;

import com.wangsong.springboot.chapter05.Dao.BookDao;
import com.wangsong.springboot.chapter05.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/20
 */
@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public void addBook(Book book) {
        bookDao.save(book);
    }

    public Page<Book> getBookByPage(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    public List<Book> getBooksByAuthorStartingWith(String author) {
        return bookDao.getBooksByAuthorStartingWith(author);
    }

    public List<Book> getBooksByPriceGreaterThan(Float pirce) {
        return bookDao.getBooksByPriceGreaterThan(pirce);
    }

    public Book getMaxIdBook() {
        return bookDao.getMaxIdBook();
    }

    public List<Book> getBookByIdAndAuthor(String author, Integer id) {
        return bookDao.getBookByIdAndAuthor(author, id);
    }

    public List<Book> getBooksByIdAndName(String name, Integer id) {
        return bookDao.getBooksByIdAndName(name, id);
    }

}
