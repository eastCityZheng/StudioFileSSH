package com.service;

import com.entity.BookEntity;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BookService {
    //添加图书
    void add(BookEntity bookEntity);
    //获取图书列表
    List<BookEntity> list(int w_id);
    //获取图书
    BookEntity findOne(int i);
    //更新图书
    void update(BookEntity bookEntity);
    //更改图书状态
    void status(BookEntity bk);
    //删除图书
    void del(BookEntity bk);
}
