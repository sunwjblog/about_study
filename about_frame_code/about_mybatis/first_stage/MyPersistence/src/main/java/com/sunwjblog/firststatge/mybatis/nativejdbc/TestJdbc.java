package com.sunwjblog.firststatge.mybatis.nativejdbc;

import com.sunwjblog.firststatge.mybatis.nativejdbc.po.User;

import java.sql.*;


/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/12 11:23 上午
 */
public class TestJdbc {

    public static void main(String[] args) {
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            //step1 start
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 通过驱动管理类获取数据库连接
            connection =
                   DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/mybatis"+
                                    "?characterEncoding=utf-8",
                            "root","1992Sunwj@");

            //存在问题1：数据库配置信息存在硬编码问题。
            //优化思路：使用配置文件！
            //step1 end

            //存在问题2：频繁创建、释放数据库连接问题
            //优化思路：使用数据连接池！

            //step2 start
            // 定义SQL语句 ？ 表示占位符
            String sql = " select * from user where username = ? ";
            // 获取预处理statement对象
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            // 第一个参数sql语句中参数的序号（从1开始）
            // 第二个参数为设置的参数值
            preparedStatement.setString(1,"panshenlian");
            // 向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();

            //存在问题3：SQL语句、设置参数、获取结果集参数均存在硬编码问题 。
            //优化思路：使用配置文件！
            //step2 end


            //step3 start
            // 遍历查询结果集
            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                // 封装User
                user.setId(id);
                user.setUserName(name);
                System.out.println(user);
            }

            //存在问题4：手动封装返回结果集，较为繁琐。
            //优化思路：使用Java反射、自省！
            //step3 end

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            // 释放资源
            if(resultSet!=null){

                try {

                    resultSet.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){

                try {

                    preparedStatement.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }
            if(connection!=null){

                try {

                    connection.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
