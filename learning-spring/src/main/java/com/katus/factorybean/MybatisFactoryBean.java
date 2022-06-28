package com.katus.factorybean;

import com.katus.demo.MybatisAppTest;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

/**
 * 实际Mybatis是通过FactoryBean的方式注册动态代理的DAO对象的
 * * FactoryBean本身是一个Bean, 可以通过名称&name取出
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
public class MybatisFactoryBean<T> implements FactoryBean<T> {
    @Setter
    private Class<T> mapperInterface;

    @Override
    public T getObject() throws Exception {
        return new MybatisAppTest().generateDao(mapperInterface);
    }

    @Override
    public Class<T> getObjectType() {
        return mapperInterface;
    }
}
