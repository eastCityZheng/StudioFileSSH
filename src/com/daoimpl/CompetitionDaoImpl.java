package com.daoimpl;

import com.dao.CompetitionDao;
import com.entity.CompetitionEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CompetitionDaoImpl extends HibernateDaoSupport implements CompetitionDao {

    @Override
    public void add(CompetitionEntity competitionEntity) {
        this.getHibernateTemplate().save(competitionEntity);
    }

    @Override
    public List<CompetitionEntity> findAll(int w_id) {
        return (List<CompetitionEntity>)this.getHibernateTemplate().find("from  CompetitionEntity where uId in (select uId from UserEntity where wId=?)",w_id);
    }

    @Override
    public CompetitionEntity findOne(int i) {
        List<CompetitionEntity> ct=(List<CompetitionEntity>)this.getHibernateTemplate().find("from CompetitionEntity where cId=?",i);
        if(ct.size()>0)
            return ct.get(0);
        else
        return null;
    }

    @Override
    public void del(CompetitionEntity ct) {
            this.getHibernateTemplate().delete(ct);
    }

    @Override
    public void update(CompetitionEntity competitionEntity) {
        this.getHibernateTemplate().update(competitionEntity);
    }
}
