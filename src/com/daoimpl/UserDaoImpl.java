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
}
