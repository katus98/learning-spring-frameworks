package com.katus.config;

import com.katus.processor.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义Mybatis扫描注解, 被修饰的配置类会使MyImportBeanDefinitionRegistrar注册器生效
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-28
 */
@Import(MyImportBeanDefinitionRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyScan {
    String value();
}
