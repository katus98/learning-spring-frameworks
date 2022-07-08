package com.katus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring容器全生命周期原理 配置类
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
@Configuration
@ComponentScan("com.katus.bean.life")
public class SpringLifeConfig {
}
