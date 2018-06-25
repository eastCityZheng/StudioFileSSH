package com.daoimpl;

import com.dao.ProjectDao;
import com.entity.ProjectListEntity;
import com.entity.ProjectfileEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

    @Override
    public void add(ProjectfileEntity projectfileEntity) {
        this.getHibernateTemplate().save(projectfileEntity);

    }

    @Override
    public List<ProjectfileEntity> list(int w_id) {

        return (List<ProjectfileEntity>)this.getHibernateTemplate().find("from ProjectfileEntity where uId in (select uId from UserEntity where wId=?)",w_id);
    }

    @Override
    public void del(ProjectfileEntity pf) {
        this.getHibernateTemplate().delete(pf);
    }

    @Override
    public ProjectfileEntity findOne(int i) {
        List<ProjectfileEntity> pf=(List<ProjectfileEntity>)this.getHibernateTemplate().find("from ProjectfileEntity where pId=?",i);
        if(pf.size()>0)
            return pf.get(0);
        return null;
    }

    @Override
    public void update(ProjectfileEntity projectfileEntity) {
        this.getHibernateTemplate().update(projectfileEntity);
    }
}
