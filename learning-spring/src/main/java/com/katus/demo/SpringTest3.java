package com.katus.demo;

import com.katus.bean.User;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-26
 */
public class SpringTest3 {
    @Test
    public void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.registerBean("user", User.class, () -> {
            User user = new User();
            user.setName("Sun");
            user.setAge(22);
            user.setAddress("Hangzhou");
            user.setDesc("Others");
            return user;
        });
        System.out.println(context.getBean("user"));
        context.close();
    }
}
