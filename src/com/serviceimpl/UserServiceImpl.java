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

    @Override
    public List<UserEntity> findAll(int w_id) {
        return userdao.findAll(w_id);
    }

    @Override
    public UserEntity findOneById(int i) {

        return userdao.findOneById(i);
    }

    @Override
    public void del(UserEntity us) {

        userdao.del(us);
    }

    @Override
    public void update(UserEntity user) {
        userdao.update(user);
    }

    @Override
    public void type(UserEntity us) {
        userdao.type(us);
    }

    @Override
    public List<UserEntity> findTea() {
        return userdao.findTea();
    }
}
