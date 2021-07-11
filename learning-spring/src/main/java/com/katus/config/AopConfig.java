package com.katus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-26
 */
@Configuration
@ComponentScan(basePackages = {"com.katus.aopanno"})
@EnableAspectJAutoProxy   // 开启AspectJ自动生成代理对象
public class AopConfig {
}
