package com.katus.aopanno;

import org.springframework.stereotype.Component;

/**
 * 被代理类
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-26
 */
@Component
public class User {
    public void add() {
        System.out.println("add...");
    }
}
