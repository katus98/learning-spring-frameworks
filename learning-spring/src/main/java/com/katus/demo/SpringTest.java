package com.katus.demo;

import com.katus.bean.Book;
import com.katus.bean.Emp;
import com.katus.bean.User;
import com.katus.bean.life.BeanLife;
import com.katus.config.SpringLifeConfig;
import com.katus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
@Slf4j
public class SpringTest {
    @Test
    public void testAdd() {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean1.xml");

        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();

        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testUpdate() {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test3() {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean7.xml");

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void testColl() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beanCollection.xml");

        System.out.println(context.getBean("coll"));
        context.close();
    }

    @Test
    public void testFactory() {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean6.xml");

        System.out.println(context.getBean("factory"));
    }

    @Test
    public void testLife() {
        // 加载Spring配置文件 创建单例bean对象 第四步
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beanLife.xml");

        System.out.println(context.getBean("order"));

        context.close();   // 调用destroy方法 第五步
    }

    @Test
    public void testInheritance() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beanInheritance.xml");

        System.out.println(context.getBean("c1"));
        System.out.println(context.getBean("c2"));

        context.close();
    }

    /**
     * Spring容器全生命周期原理
     */
    @Test
    public void testSpringLife() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringLifeConfig.class);
        BeanLife beanLife = context.getBean(BeanLife.class);
        log.info("{}-using......", beanLife.getClass());
        context.close();
    }
}
