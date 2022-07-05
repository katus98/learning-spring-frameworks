package com.katus.demo;

import com.katus.processor.RegistryProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
@Slf4j
public class ScanTest {
    /**
     * 测试Spring扫描原理的启动类
     * 因为没有启动扫描注解, Spring本身不会启动扫描
     */
    @Test
    public void testScan() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(RegistryProcessor.class);
        context.refresh();
        log.info(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
