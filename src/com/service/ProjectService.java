package com.service;

import com.entity.ProjectfileEntity;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProjectService {
    //添加项目
    void add(ProjectfileEntity projectfileEntity);
    //获取项目列表
    List<ProjectfileEntity> list(int w_id);
    //查找一个项目
    ProjectfileEntity findOne(int i);
    //删除项目
    void del(ProjectfileEntity pf);
    //更新项目
    void update(ProjectfileEntity projectfileEntity);
}
