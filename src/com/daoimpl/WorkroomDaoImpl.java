package com.daoimpl;

import com.dao.WorkroomDao;
import com.entity.WorkroomEntity;
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
}
