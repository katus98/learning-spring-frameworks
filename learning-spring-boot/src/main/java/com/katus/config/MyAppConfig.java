package com.katus.config;

import com.katus.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-27
 */
@Configuration
public class MyAppConfig {
    @Bean   // 返回值注入容器 id为方法名
    public HelloService helloService() {
        return new HelloService();
    }
}
