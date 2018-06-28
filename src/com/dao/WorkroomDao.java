package com.dao;

import com.entity.WorkroomEntity;

import java.util.List;

public interface WorkroomDao {
    List<WorkroomEntity> getList();

    void add(WorkroomEntity workroomEntity);

    void del(WorkroomEntity wr);

    void update(WorkroomEntity workroomEntity);

    WorkroomEntity findOne(int i);

    String findNameById(int i);
}
