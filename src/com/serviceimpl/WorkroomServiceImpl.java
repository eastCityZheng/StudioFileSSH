package com.serviceimpl;

import com.dao.WorkroomDao;
import com.entity.WorkroomEntity;
import com.service.WorkroomService;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class WorkroomServiceImpl implements WorkroomService {

    private WorkroomDao workroomDao;

    public void setWorkroomDao(WorkroomDao workroomDao) {
        this.workroomDao = workroomDao;
    }

    @Override
    public List<WorkroomEntity> getList( ) {
        List<WorkroomEntity> workroomEntity1=workroomDao.getList();

        return workroomEntity1;
    }

    @Override
    public void add(WorkroomEntity workroomEntity) {
        workroomDao.add(workroomEntity);
    }

    @Override
    public WorkroomEntity findOne(int i) {
        return workroomDao.findOne(i);
    }

    @Override
    public void del(WorkroomEntity wr) {
        workroomDao.del(wr);
    }

    @Override
    public void update(WorkroomEntity workroomEntity) {
        workroomDao.update(workroomEntity);
    }
}
