package com.katus.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-26
 */
@Component
@Aspect
@Order(1)   // 设置增强优先级 数字从0开始 越小优先级越高
public class UserProxy2 {
    @Before(value = "execution(* com.katus.aopanno.User.add(..))")
    public void before() {
        System.out.println("UserProxy2 before...");
    }
}
