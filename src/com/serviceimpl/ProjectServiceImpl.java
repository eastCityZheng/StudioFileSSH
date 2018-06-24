package com.serviceimpl;

import com.dao.ProjectDao;
import com.entity.ProjectfileEntity;
import com.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    @Override
    public void add(ProjectfileEntity projectfileEntity) {
       projectDao.add(projectfileEntity);
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
}
