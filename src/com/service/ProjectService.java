package com.service;

import com.entity.ProjectfileEntity;

import javax.transaction.Transactional;

@Transactional
public interface ProjectService {

    void add(ProjectfileEntity projectfileEntity);
}
