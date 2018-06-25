package com.daoimpl;

import com.dao.SoftwareDao;
import com.entity.SoftwareEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class SoftwareDaoImpl extends HibernateDaoSupport implements SoftwareDao {

    @Override
    public void add(SoftwareEntity softwareEntity) {
        this.getHibernateTemplate().save(softwareEntity);
    }

    @Override
    public List<SoftwareEntity> findAll(int w_id) {

        return (List<SoftwareEntity>)this.getHibernateTemplate().find("from SoftwareEntity where uId in (select uId from UserEntity where wId=?)",w_id);
    }

    @Override
    public void del(SoftwareEntity sw) {
        this.getHibernateTemplate().delete(sw);
    }

    @Override
    public SoftwareEntity findOne(SoftwareEntity softwareEntity) {
        List<SoftwareEntity> swList=(List<SoftwareEntity>)this.getHibernateTemplate().find("from SoftwareEntity where sId=?",softwareEntity.getsId());
        if(swList.size()>0)
            return swList.get(0);
        else
        return null;
    }

    @Override
    public void update(SoftwareEntity softwareEntity) {
        this.getHibernateTemplate().update(softwareEntity);
    }
}
