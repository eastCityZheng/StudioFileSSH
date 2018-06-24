package com.dao;

import com.entity.UserEntity;

/**
 * 用户管理的DAO接口
 */
public interface UserDao {

    UserEntity findByAccountAndPassword(UserEntity us);
}
