package com.katus.mybatis;

import com.katus.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-07
 */
@Slf4j
public class MybatisTest {
    @Test
    public void testBasic() throws IOException {
        String resource = "mybatis-config.xml";
        // 获取主配置文件输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过配置文件获得Sql会话建造器
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过建造器获取Sql会话
        SqlSession session = sqlSessionFactory.openSession();
        // 通过Sql会话执行Sql方法
        Object o = session.selectOne("com.katus.mybatis.mapper.UserMapper.selectUserById", 1L);
        log.info("1: [{}]", o);
        Object z = session.selectOne("com.katus.mybatis.mapper.UserMapper.selectUserById", 1L);
        log.info("2: [{}]", z);
        // 通过Sql会话对象获取mapper实现类
        UserMapper userMapper = session.getMapper(UserMapper.class);
        log.info("3: [{}]", userMapper.selectUserById(2L));
        // 关闭Sql会话
        session.close();
    }
}
