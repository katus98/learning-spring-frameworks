package com.katus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

// @ImportResource(value = {"classpath:bean.xml"})   // 加载Spring配置文件
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

}
