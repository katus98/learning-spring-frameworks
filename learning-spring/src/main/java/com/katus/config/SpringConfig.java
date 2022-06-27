package com.katus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 简单说一下@Component注解与@Bean注解的区别
 * 注解@Component是将对应的类注册给IoC容器, 这个类实例化的过程是由Spring控制的;
 * 注解@Bean是将一个实例对象直接加入IoC容器, 这个对象的生成过程由用户自己控制
 *
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
@Configuration
@ComponentScan(basePackages = {"com.katus"})
public class SpringConfig {

}
