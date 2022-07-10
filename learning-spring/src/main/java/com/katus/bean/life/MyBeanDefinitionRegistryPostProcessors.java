package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-10
 */
@Component
@Slf4j
public class MyBeanDefinitionRegistryPostProcessors implements BeanDefinitionRegistryPostProcessor {
    public MyBeanDefinitionRegistryPostProcessors() {
        log.info("{}-Construction()", this.getClass());
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("{}-postProcessBeanDefinitionRegistry()", this.getClass());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("{}-postProcessBeanFactory()", this.getClass());
    }
}
