package com.katus.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * BeanFactory后置处理器
 * 如果要让当前类的回调生效需要注册到容器中
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-28
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * Bean初始化之前的回调, 即Spring完成类扫描和BeanDefinition生成之后
     * 主要用于对上下文做全局性修改, 可以一定程度上修改BeanDefinition
     *
     * @param beanFactory the bean factory used by the application context
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 此处修改了名称为name的BeanDefinition中的Bean类名
        BeanDefinition definition = beanFactory.getBeanDefinition("name");
        definition.setBeanClassName("com...");
        // 但是这个回调无法新增或者删除BeanDefinition
    }
}
