package com.katus.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

/**
 * Spring Component 扫描原理的简单实现
 * Spring内部提前注册了ConfigurationClassPostProcessor
 * Spring初始化过程中执行BeanFactory的时候会执行ConfigurationClassPostProcessor中的扫描逻辑
 * 本类是对Spring内部的ConfigurationClassPostProcessor的简单实现
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 * @see ConfigurationClassPostProcessor
 */
public class RegistryProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 扫描com.katus.bean.scan包下的bean
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        // 扫描大致步骤
        // 1 将包名替换为文件路径层级
        // 2 递归获取下面所有的字节码文件
        // 3 通过ASM技术解析类并判断是否被过滤掉(匹配任意exclude过滤器列表)/是否符合条件(匹配任意include过滤器列表, Component注解就是这里面的条件)
        scanner.scan("com.katus.bean.scan");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
