package com.serviceimpl;

import com.dao.ProjectDao;
import com.entity.ProjectListEntity;
import com.entity.ProjectfileEntity;
import com.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    @Override
    public void add(ProjectfileEntity projectfileEntity) {
       projectDao.add(projectfileEntity);
    }

    @Override
    public List<ProjectfileEntity> list(int w_id) {

        return projectDao.list(w_id);
    }

    @Override
    public ProjectfileEntity findOne(int i) {
        return projectDao.findOne(i);
    }

    @Override
    public void del(ProjectfileEntity pf) {
    projectDao.del(pf);
    }

    @Override
    public void update(ProjectfileEntity projectfileEntity) {
        projectDao.update(projectfileEntity);
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
}
