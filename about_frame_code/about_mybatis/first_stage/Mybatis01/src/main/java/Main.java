import com.sunwjblog.mybatis01.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/12 2:40 下午
 */
public class Main {

    public static void main(String[] args) throws Exception{
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
}
