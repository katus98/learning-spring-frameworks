package com.katus.demo;

import com.katus.config.SpringConfig;
import com.katus.service.TradeService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
public class SpringTest2 {
    @Test
    public void test1() {
        // 加载Spring配置文件
        ApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\Codes\\spring-learning\\src\\main\\resources\\beanAnno.xml");
        context.getBean("tradeService", TradeService.class).start();
    }

    @Test
    public void test2() {
        // 加载Spring配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.getBean("tradeService", TradeService.class).start();
    }
}
