package com.daoimpl;

import com.dao.UserDao;
import com.entity.UserEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;


/**
 * 用户管理的DAO的实现类
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public UserEntity findByAccountAndPassword(UserEntity us) {
        String hql="from UserEntity where uAccount=? and uPassword=?";
        List<UserEntity> usList=(List<UserEntity>)this.getHibernateTemplate().find(hql,us.getuAccount(),us.getuPassword());
        if(usList.size()>0)
            return usList.get(0);
        return null;
    }

    @Override
    public void add(UserEntity us) {
        this.getHibernateTemplate().save(us);
    }

    @Override
    public List<UserEntity> findOne(String account) {

        return (List<UserEntity>) this.getHibernateTemplate().find("from UserEntity where uAccount=?",account);
    }

    @Override
    public String findOneName(int i) {
        List<String> s=(List<String>)this.getHibernateTemplate().find("select uName from UserEntity where uId=?",i);
        if(s.size()>0)
            return s.get(0);
        return null;
    }

    @Override
    public List<UserEntity> findAll(int w_id) {
        return (List<UserEntity>)this.getHibernateTemplate().find("from UserEntity where wId=?",w_id);
    }

    @Override
    public UserEntity findOneById(int i) {
        List<UserEntity> usList=(List<UserEntity>)this.getHibernateTemplate().find("from UserEntity where uId=?",i);
        if (usList.size()>0)
            return usList.get(0);
        else
        return null;
    }

    @Override
    public void del(UserEntity us) {
        this.getHibernateTemplate().delete(us);
    }

    @Override
    public void update(UserEntity user) {
        this.getHibernateTemplate().update(user);
    }

    @Override
    public void type(UserEntity us) {
        this.getHibernateTemplate().update(us);
    }

    @Override
    public List<UserEntity> findTea() {
        return (List<UserEntity>)this.getHibernateTemplate().find("from UserEntity where uType=?",2);
    }
}
