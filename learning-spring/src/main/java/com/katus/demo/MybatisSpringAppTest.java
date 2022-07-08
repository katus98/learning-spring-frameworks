package com.katus.demo;

import com.katus.bean.my.User;
import com.katus.config.MyAdvancedMybatisConfig;
import com.katus.config.MybatisConfig;
import com.katus.dao.ModelClassDao;
import com.katus.mapper.UserMapper;
import com.katus.service.ModelClassService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Mybatis 与 Spring 结合
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
@Slf4j
public class MybatisSpringAppTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        ModelClassService service = context.getBean(ModelClassService.class);
        log.info("{}", service.queryAll());
        context.close();
    }

    /**
     * 一种将原生Mybatis与Spring结合的方法
     * * 利用API进行调用
     * * 另外可以使用@Bean进行对象的注册
     */
    @Test
    public void testCombine() {
        // 先不扫描实例化bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册配置类
        context.register(MybatisConfig.class);
        // 通过Bean工厂单例注册Mybatis动态代理生成的ModelClassDao接口代理对象
        context.getBeanFactory().registerSingleton("modelClassDao", new MybatisAppTest().generateDao(ModelClassDao.class));
        // 扫描实例化Bean
        context.refresh();
        ModelClassService service = context.getBean(ModelClassService.class);
        log.info("{}", service.queryAll());
        context.close();
    }

    /**
     * 实际Mybatis是通过BeanFactory注册对象的
     * BeanFactory的注册通过MybatisConfig.xml配置文件实现
     *
     * @see com.katus.factorybean.MybatisFactoryBean
     */
    @Test
    public void testRealCombine() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        /*
        容器初始化流程
        注册Spring内部自用类
        注册主配置类
        扫描自定义类
        @Import ImportBeanDefinitionRegistrar回调
        BeanFactoryPostProcessor回调
        实例化Bean
        Bean依赖注入(getBean递归获取)
        aware回调
        BeanPostProcessor初始化前回调
        初始化方法
        BeanPostProcessor初始化后回调
        放入单例池
         */
        ModelClassService service = context.getBean(ModelClassService.class);
        log.info("{}", service.queryAll());
        context.close();
    }

    /**
     * 一个自定义实现的Mybatis注解扫描
     */
    @Test
    public void testMySpringMybatis() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAdvancedMybatisConfig.class);
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.selectUserById(1L);
        log.info("User Id 1 : [{}]", user);
        context.close();
    }
}
