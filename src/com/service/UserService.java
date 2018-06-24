package com.service;

import com.entity.UserEntity;

/**
 * 用户管理的业务层的接口
 */
public interface UserService {
    UserEntity login(UserEntity us);
}
