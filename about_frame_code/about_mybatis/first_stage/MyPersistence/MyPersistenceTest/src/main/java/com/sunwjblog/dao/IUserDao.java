package com.sunwjblog.dao;

import com.sunwjblog.pojo.User;

import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/12 1:34 下午
 */
public interface IUserDao {

    /** * 查询所有用户 * @return * @throws Exception */
    public List<User> findAll() throws Exception;

    /** * 根据条件进行用户查询 * @return * @throws Exception */
    public User findByCondition(User user) throws Exception;
}
