package com.serviceimpl;

import com.dao.BookDao;
import com.entity.BookEntity;
import com.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void add(BookEntity bookEntity) {
        bookDao.add(bookEntity);
    }

    @Override
    public List<BookEntity> list(int w_id) {
        return bookDao.list(w_id);
    }

    @Override
    public BookEntity findOne(int i) {
        return bookDao.findOne(i);
    }

    @Override
    public void update(BookEntity bookEntity) {
        bookDao.update(bookEntity);
    }

    @Override
    public void status(BookEntity bk) {
        bookDao.status(bk);
    }

    @Override
    public void del(BookEntity bk) {
        bookDao.del(bk);
    }
}
