package com.service;

import com.entity.WorkroomEntity;

import java.util.List;

public interface WorkroomService {
    List<WorkroomEntity> getList();
    //添加
    void add(WorkroomEntity workroomEntity);

    WorkroomEntity findOne(int i);

    void del(WorkroomEntity wr);

    void update(WorkroomEntity workroomEntity);
    //获取名称
    String findNameById(int i);
}
