package com.service;

import com.entity.UserEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 用户管理的业务层的接口
 */
@Transactional
public interface UserService {
    UserEntity login(UserEntity us);

    void add(UserEntity user);

    List<UserEntity> findOne(String account);
    //获取用户姓名
    String findOneName(int i);
}
