package com.serviceimpl;

import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.UserService;

import java.util.List;

/**
 * 员工管理层的实现类
 */
public class UserServiceImpl implements UserService {
    private UserDao userdao;

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public UserEntity login(UserEntity us) {
        UserEntity exitUser=userdao.findByAccountAndPassword(us);
        return exitUser;
    }

    @Override
    public void add(UserEntity user) {
        userdao.add(user);
    }

    @Override
    public List<UserEntity> findOne(String account) {
        return  userdao.findOne(account);
    }

    @Override
    public String findOneName(int i) {
        return userdao.findOneName(i);
    }
}
