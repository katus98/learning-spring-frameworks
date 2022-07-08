package com.katus.factorybean;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
@Slf4j
public class MyAdvancedMybatisFactoryBean<T> implements FactoryBean<T> {
    private Class<T> mapperInterface;
    private SqlSessionFactory sqlSessionFactory;

    public MyAdvancedMybatisFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.getConfiguration().addMapper(mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, new MapperHandler(sqlSessionFactory, sqlSession.getMapper(mapperInterface)));
    }

    @Override
    public Class<T> getObjectType() {
        return mapperInterface;
    }

    @Slf4j
    public static class MapperHandler implements InvocationHandler {
        private final SqlSessionFactory sqlSessionFactory;
        private final Object mapper;

        public MapperHandler(SqlSessionFactory sqlSessionFactory, Object mapper) {
            this.sqlSessionFactory = sqlSessionFactory;
            this.mapper = mapper;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            } else {
                if (method.isAnnotationPresent(Select.class)) {
                    String[] selectSql = method.getAnnotation(Select.class).value();
                    log.info("sql:[{}]", Arrays.toString(selectSql));
                }
                return method.invoke(mapper, args);
            }
        }
    }

    public void setMapperInterface(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
