package com.dao;

import com.entity.UserEntity;

import java.util.List;

/**
 * 用户管理的DAO接口
 */
public interface UserDao {

    UserEntity findByAccountAndPassword(UserEntity us);
    void add(UserEntity us);

    List<UserEntity> findOne(String account);

    String findOneName(int i);

    List<UserEntity> findAll(int w_id);

    UserEntity findOneById(int i);

    void del(UserEntity us);

    void update(UserEntity user);
}
