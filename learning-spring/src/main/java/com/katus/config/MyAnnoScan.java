package com.katus.config;

import com.katus.bean.life.MyAnotherImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MyAnotherImportBeanDefinitionRegistrar.class})
public @interface MyAnnoScan {
}
