package com.example.sunwj.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sunwj.mybatisplus.dao.UserMapper;
import com.example.sunwj.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusApplicationTests {

	@Autowired
	private UserMapper userMapper;


	@Test
	public void select() {
		List<User> list = userMapper.selectList(null);
		list.forEach(System.out::println);
	}

}
