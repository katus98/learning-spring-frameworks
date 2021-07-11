package com.katus.service;

import com.katus.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
// value 可以省略 默认值是类名首字母小写 效果等同于bean标签里的id属性值 以下四个标签在创建对象实例时作用一致
@Component(value = "service")
//@Service
//@Controller
//@Repository
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("Service add...");
        userDao.update();
    }
}
