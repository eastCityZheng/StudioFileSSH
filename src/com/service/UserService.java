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
    //获取用户列表
    List<UserEntity> findAll(int w_id);
    //通过Id获取一个用户
    UserEntity findOneById(int i);
    //删除用户
    void del(UserEntity us);
    //更新用户
    void update(UserEntity user);
}
