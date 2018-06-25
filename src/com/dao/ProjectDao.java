package com.dao;

import com.entity.ProjectListEntity;
import com.entity.ProjectfileEntity;

import java.util.List;

public interface ProjectDao {

    void add(ProjectfileEntity projectfileEntity);

    List<ProjectfileEntity> list(int w_id);

    void del(ProjectfileEntity pf);

    ProjectfileEntity findOne(int i);

    void update(ProjectfileEntity projectfileEntity);
}
