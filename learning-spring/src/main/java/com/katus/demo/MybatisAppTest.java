package com.katus.demo;

import com.katus.bean.ModelClass;
import com.katus.config.MybatisConfig;
import com.katus.dao.ModelClassDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.util.List;

/**
 * 原生Mybatis
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
@Slf4j
public class MybatisAppTest {
    /**
     * 纯Mybatis基本使用
     */
    @Test
    public void test() {
        SqlSession sqlSession = obtainSqlSessionFactory().openSession();
        // 内部使用jdk动态代理技术生成了ModelClassDao接口的代理对象
        // Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface}, mapperProxy)
        ModelClassDao dao = sqlSession.getMapper(ModelClassDao.class);
        List<ModelClass> list = dao.queryAll();
        log.info("{}", list);
        sqlSession.close();
    }

    public <T> T generateDao(Class<T> clazz) {
        SqlSession sqlSession = obtainSqlSessionFactory().openSession();
        return sqlSession.getMapper(clazz);
    }

    private SqlSessionFactory obtainSqlSessionFactory() {
        DataSource dataSource = new MybatisConfig().dataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("test", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(ModelClassDao.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
