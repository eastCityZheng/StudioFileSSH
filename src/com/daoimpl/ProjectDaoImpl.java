package com.daoimpl;

import com.dao.ProjectDao;
import com.entity.ProjectfileEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

    @Override
    public void add(ProjectfileEntity projectfileEntity) {
        this.getHibernateTemplate().save(projectfileEntity);

    }
}
