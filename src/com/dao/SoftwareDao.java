package com.dao;

import com.entity.SoftwareEntity;

import java.util.List;

public interface SoftwareDao {
    void add(SoftwareEntity softwareEntity);

    List<SoftwareEntity> findAll(int w_id);

    void del(SoftwareEntity sw);

    SoftwareEntity findOne(SoftwareEntity softwareEntity);

    void update(SoftwareEntity softwareEntity);
}
