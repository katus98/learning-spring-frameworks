package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
@Slf4j
public class MyAnotherImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public MyAnotherImportBeanDefinitionRegistrar() {
        log.info("{}-Construction()", this.getClass());
    }

    /**
     * 有两个方法, 只实现一个才会生效, 否则只会生效参数多的这个
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        log.info("{}-registerBeanDefinitions() withBeanNameGenerator", this.getClass());
    }
}
