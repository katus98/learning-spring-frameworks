package com.katus.processor;

import com.katus.config.MyMapperScanner;
import com.katus.config.MyScan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Optional;

/**
 * 导入BeanDefinition注册器
 * 如果想让这个回调生效需要@Import(MyImportBeanDefinitionRegistrar.class)修饰配置类或者注解(用自定义注解修饰配置类)
 * Mybatis就是使用这种方法将扫描到的Mapper接口的代理类批量动态注册到Spring容器中的
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-28
 */
@Slf4j
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 回调方法允许用户向Spring BeanDefinition Map中注册新的 BeanDefinition
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        log.info("ImportBeanDefinitionRegistrar.registerBeanDefinitions()......");
        // 获取MyScan注解上的参数
        MergedAnnotation<MyScan> annotation = importingClassMetadata.getAnnotations().get(MyScan.class);
        Optional<Object> pakOpt = annotation.getValue("value");
        String pak;
        if (pakOpt.isPresent()) {
            pak = (String) pakOpt.get();
            log.info("MyScan: value = [{}]", pak);
            MyMapperScanner scanner = new MyMapperScanner(registry);
            scanner.scan(pak);
        }
        // 注册新的BeanDefinition
        // registry.registerBeanDefinition(mapperClass.getSimpleName(), beanDefinition);
        // 移除旧的BeanDefinition
        // registry.removeBeanDefinition("name");
    }
}
