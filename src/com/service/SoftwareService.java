package com.service;

import com.entity.SoftwareEntity;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SoftwareService {
    //添加软件
    void add(SoftwareEntity softwareEntity);
    //获取软件列表
    List<SoftwareEntity> findAll(int w_id);
    //获取一个软件
    SoftwareEntity findOne(SoftwareEntity softwareEntity);
    //删除软件
    void del(SoftwareEntity sw);
    //更新软件
    void update(SoftwareEntity softwareEntity);
}
