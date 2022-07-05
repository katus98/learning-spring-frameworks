package com.katus.aopanno;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
@Slf4j
public class UserAspect {
    public void before() {
        log.info("UserProxy2 before...");
    }
}
