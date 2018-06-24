package com.serviceimpl;

import com.dao.WorkroomDao;
import com.entity.WorkroomEntity;
import com.service.WorkroomService;

import java.util.List;

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
}
