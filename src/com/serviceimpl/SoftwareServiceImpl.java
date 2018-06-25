package com.serviceimpl;

import com.dao.SoftwareDao;
import com.entity.SoftwareEntity;
import com.service.SoftwareService;

import java.util.List;

public class SoftwareServiceImpl implements SoftwareService {
    private SoftwareDao softwareDao;

    public void setSoftwareDao(SoftwareDao softwareDao) {
        this.softwareDao = softwareDao;
    }

    @Override
    public void add(SoftwareEntity softwareEntity) {
        softwareDao.add(softwareEntity);
    }

    @Override
    public List<SoftwareEntity> findAll(int w_id) {
        return softwareDao.findAll(w_id);
    }

    @Override
    public SoftwareEntity findOne(SoftwareEntity softwareEntity) {
        return softwareDao.findOne(softwareEntity);
    }

    @Override
    public void del(SoftwareEntity sw) {
        softwareDao.del(sw);
    }

    @Override
    public void update(SoftwareEntity softwareEntity) {
        softwareDao.update(softwareEntity);
    }
}
