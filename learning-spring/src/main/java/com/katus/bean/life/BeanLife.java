package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
@Component
@Slf4j
public class BeanLife implements InitializingBean, BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware, DisposableBean, SmartInitializingSingleton {
    private Member member;

    public BeanLife() {
        log.info("{}-Construction()", this.getClass());
    }

    @Autowired
    public void setMember(Member member) {
        log.info("{}-setMember()", this.getClass());
        this.member = member;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("{}-setBeanClassLoader()", this.getClass());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("{}-setBeanFactory()", this.getClass());
    }

    @Override
    public void setBeanName(String name) {
        log.info("{}-setBeanName()", this.getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("{}-setApplicationContext()", this.getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("{}-afterPropertiesSet()", this.getClass());
    }

    @Override
    public void destroy() throws Exception {
        log.info("{}-destroy()", this.getClass());
    }

    @Override
    public void afterSingletonsInstantiated() {
        log.info("{}-afterSingletonsInstantiated()", this.getClass());
    }
}
