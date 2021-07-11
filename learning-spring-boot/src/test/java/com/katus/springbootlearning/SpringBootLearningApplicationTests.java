package com.katus.springbootlearning;

import com.katus.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootLearningApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        logger.trace("trace");
        logger.debug("debug");
        // 默认输出以下级别的日志
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        System.out.println(person);
    }

    @Test
    void testConfigClass() {
        System.out.println(ioc.containsBean("helloService"));
    }

}
