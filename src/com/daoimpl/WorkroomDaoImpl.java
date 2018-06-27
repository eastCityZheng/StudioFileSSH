package com.daoimpl;

import com.dao.WorkroomDao;
import com.entity.WorkroomEntity;
import org.hibernate.jdbc.WorkExecutor;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class WorkroomDaoImpl extends HibernateDaoSupport implements WorkroomDao {

    /**
     * 获取工作室列表
     * @return
     */
    @Override
    public List<WorkroomEntity> getList() {
        return (List<WorkroomEntity>) this.getHibernateTemplate().find("from WorkroomEntity ");
    }

    @Override
    public void add(WorkroomEntity workroomEntity) {
        this.getHibernateTemplate().save(workroomEntity);
    }

    @Override
    public void del(WorkroomEntity wr) {
        this.getHibernateTemplate().delete(wr);
    }

    @Override
    public void update(WorkroomEntity workroomEntity) {
        this.getHibernateTemplate().update(workroomEntity);
    }

    @Override
    public WorkroomEntity findOne(int i) {
        List<WorkroomEntity> wrList=(List<WorkroomEntity>)this.getHibernateTemplate().find("from WorkroomEntity where wId=?",i);
        if(wrList.size()>0)
            return wrList.get(0);
        else
        return null;
    }
}
