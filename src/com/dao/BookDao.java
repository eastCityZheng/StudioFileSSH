package com.dao;

import com.entity.BookEntity;

import java.util.List;

public interface BookDao {
    void add(BookEntity bookEntity);

    List<BookEntity> list(int w_id);

    BookEntity findOne(int i);

    void update(BookEntity bookEntity);

    void status(BookEntity bk);

    void del(BookEntity bk);
}
