package com.katus.demo;

import com.katus.aopanno.User;
import com.katus.config.AopConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-26
 */
public class AopTest {
    @Test
    public void test1() {
        // 加载Spring配置文件
        ApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\Learning\\spring-learning\\src\\main\\resources\\beanAop.xml");
        context.getBean("user", User.class).add();
    }

    @Test
    public void test2() {
        // 加载Spring配置文件
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        context.getBean("user", User.class).add();
    }
}
