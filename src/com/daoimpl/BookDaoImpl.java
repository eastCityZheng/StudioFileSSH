package com.daoimpl;

import com.dao.BookDao;
import com.entity.BookEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

    @Override
    public void add(BookEntity bookEntity) {
        this.getHibernateTemplate().save(bookEntity);
    }

    @Override
    public List<BookEntity> list(int w_id) {

        return (List<BookEntity>)this.getHibernateTemplate().find("from BookEntity where wId=?",w_id);
    }

    @Override
    public BookEntity findOne(int i) {
        List<BookEntity> bkList=(List<BookEntity>)this.getHibernateTemplate().find("from BookEntity where bId=?",i);
        if (bkList.size()>0)
            return bkList.get(0);
        else
        return null;
    }

    @Override
    public void update(BookEntity bookEntity) {
            this.getHibernateTemplate().update(bookEntity);
    }

    @Override
    public void status(BookEntity bk) {
        this.getHibernateTemplate().update(bk);
    }

    @Override
    public void del(BookEntity bk) {
        this.getHibernateTemplate().delete(bk);
    }
}
