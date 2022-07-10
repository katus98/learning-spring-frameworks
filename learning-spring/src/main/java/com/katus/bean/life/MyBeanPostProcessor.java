package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
@Component
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        log.info("{}-Construction()", this.getClass());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("beanName: [{}], {}-postProcessBeforeInitialization()", beanName, this.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("beanName: [{}], {}-postProcessAfterInitialization()", beanName, this.getClass());
        return bean;
    }
}
