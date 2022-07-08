package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
@Aspect
@Component
@Slf4j
public class MyAspect {
    @Pointcut("execution(* com.katus.bean.life.JoinPoint.*(..))")
    private void point() {}

    @Before("point()")
    public void before() {
        log.info("{}-before()", this.getClass());
    }

    @After("point()")
    public void after() {
        log.info("{}-after()", this.getClass());
    }
}
