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
}