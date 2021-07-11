package com.katus.demo;

import com.katus.bean.Book;
import com.katus.bean.User;
import com.katus.bean.Emp;
import com.katus.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
public class SpringTest {
    @Test
    public void testAdd() {
        // 加载Spring配置文件
        ApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\spring-learning\\src\\main\\resources\\bean1.xml");

        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();

        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testUpdate() {
        // 加载Spring配置文件
        ApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\spring-learning\\src\\main\\resources\\bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test3() {
        // 加载Spring配置文件
        ApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\spring-learning\\src\\main\\resources\\bean7.xml");

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void testColl() {
        // 加载Spring配置文件
        ApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\spring-learning\\src\\main\\resources\\bean5.xml");

        System.out.println(context.getBean("coll"));
    }

    @Test
    public void testFactory() {
        // 加载Spring配置文件
        ApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\spring-learning\\src\\main\\resources\\bean6.xml");

        System.out.println(context.getBean("factory"));
    }

    @Test
    public void testLife() {
        // 加载Spring配置文件 创建单例bean对象 第四步
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\spring-learning\\src\\main\\resources\\beanLife.xml");

        System.out.println(context.getBean("order"));

        context.close();   // 调用destroy方法 第五步
    }
}
