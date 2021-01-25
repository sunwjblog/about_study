package com.example.sunwj.mybatisplus.service;

import com.example.sunwj.mybatisplus.entity.User;

import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/21 6:47 下午
 */
public interface IUserService {

    List<User> getAllUser();
}
