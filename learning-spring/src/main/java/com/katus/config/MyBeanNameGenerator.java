package com.katus.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 自定义Bean名称命名器
 * 需要@ComponentScan(nameGenerator = MyBeanNameGenerator.class)生效
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
public class MyBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        // 根据BeanDefinition定制自己的Bean命名策略
        return definition.getBeanClassName() + "_HHH";
    }
}
