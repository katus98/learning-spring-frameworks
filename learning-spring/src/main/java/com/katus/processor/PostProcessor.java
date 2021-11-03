package com.katus.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
public class PostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {   // life第三步前
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization:");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {   // life第三步后
        System.out.println("BeanPostProcessor.postProcessAfterInitialization:");
        return bean;
    }
}
