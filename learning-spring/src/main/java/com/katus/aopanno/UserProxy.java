package com.katus.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 代理类
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
@Component
@Aspect
@Order(0)   // 设置增强优先级 数字从0开始 越小优先级越高
public class UserProxy {
    // 公共切入点抽取 方便维护
    @Pointcut(value = "execution(* com.katus.aopanno.User.add(..))")
    public void point() {}

    // 前置通知 无论如何都会执行
    @Before(value = "point()")
    public void before() {
        System.out.println("before...");
    }

    // 最终通知 无论如何都会执行
    @After(value = "point()")
    public void after() {
        System.out.println("after...");
    }

    // 环绕通知 如果有异常环绕后的不会执行
    @Around(value = "execution(* com.katus.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around1...");
        proceedingJoinPoint.proceed();   // 被增强的方法执行
        System.out.println("around2...");
    }

    // 异常通知 有异常才执行
    @AfterThrowing(value = "execution(* com.katus.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("after throwing...");
    }

    // 后置/返回通知 如果有异常不会执行
    @AfterReturning(value = "execution(* com.katus.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("after returning");
    }
}
