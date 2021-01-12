package com.sunwjblog.test;

import com.sunwjblog.dao.IUserDao;
import com.sunwjblog.firststatge.mybatis.handwritingframe.io.Resource;
import com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession.SqlSession;
import com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession.SqlSessionFactory;
import com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession.SqlSessionFactoryBuilder;
import com.sunwjblog.pojo.User;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/12 1:35 下午
 */
public class MyPersistenceTest {

    @Test
    public void test() throws Exception {

        InputStream resourceAsStream =
                Resource.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 一、传统DAO方式调用
        User user = new User();
        user.setId(3);
        user.setUsername("panshenlian");
        user.setBirthday("2020-11-12");
        user.setPassword("123456");
        //User dbUser = sqlSession.selectOne("com.sunwjblog.dao.IUserDao.findByCondition",user);
        //System.out.println(dbUser);
        List<User> userList = sqlSession.selectList("com.sunwjblog.dao.IUserDao.findAll", user);
        for (User db : userList) {

            System.out.println(db);
        }

        // 二、代理模式调用
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User db : users) {

            System.out.println("代理调用=" + db);
        }

    }
}
