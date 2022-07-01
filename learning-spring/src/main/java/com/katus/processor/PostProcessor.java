package com.katus.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
@Slf4j
@Component
public class PostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {   // life第三步前
        log.info("BeanPostProcessor.postProcessBeforeInitialization()......");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {   // life第三步后
        log.info("BeanPostProcessor.postProcessAfterInitialization()......");
        return bean;
    }
}
