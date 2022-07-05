package com.katus.aopanno;

import lombok.extern.slf4j.Slf4j;

/**
 * 被代理类
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
@Slf4j
public class User implements Person {
    @MyAsp
    @Override
    public void add() {
        log.info("add...");
    }
}
