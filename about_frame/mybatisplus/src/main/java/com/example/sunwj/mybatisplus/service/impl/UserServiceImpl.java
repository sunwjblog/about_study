package com.example.sunwj.mybatisplus.service.impl;

import com.example.sunwj.mybatisplus.dao.UserMapper;
import com.example.sunwj.mybatisplus.entity.User;
import com.example.sunwj.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/21 6:47 下午
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        List<User> list = userMapper.selectList(null);
        return list;
    }
}
