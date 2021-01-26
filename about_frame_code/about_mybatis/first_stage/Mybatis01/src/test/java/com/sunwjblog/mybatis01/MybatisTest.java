package com.sunwjblog.mybatis01;

import com.sunwjblog.mybatis01.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/12 2:44 下午
 */
public class MybatisTest {

    @Test
    public void testQueryUser01() throws IOException {


        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql语句
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        // 打印结果
        for (User user : userList) {

            System.out.println(user);
        }

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testInsertUser01() throws IOException {


        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 准备插入数据库的对象
        User insertUser = new User();
        insertUser.setBirthday("2020-12-01");
        insertUser.setUsername("panpan");
        insertUser.setPassword("888");

        // 执行sql语句
        int rows = sqlSession.insert("userMapper.insertUser",insertUser);

        // 打印结果
        System.out.println(rows);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdateUser01() throws IOException {


        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User updateUser = new User();
        updateUser.setUsername("新的用户名PanPan");
        updateUser.setId(1);

        // 执行sql语句
        int rows = sqlSession.update("userMapper.updateUser",updateUser);

        // 打印结果
        System.out.println(rows);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteUser01() throws IOException {


        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User deleteUser = new User();
        deleteUser.setUsername("新的用户名PanPan");
        deleteUser.setId(1);

        // 执行sql语句
        int rows = sqlSession.delete("userMapper.deleteUser",deleteUser);

        // 打印结果
        System.out.println(rows);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }
}
