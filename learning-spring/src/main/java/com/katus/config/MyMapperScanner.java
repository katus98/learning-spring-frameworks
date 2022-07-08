package com.katus.config;

import com.katus.factorybean.MyAdvancedMybatisFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

/**
 * 自定义包扫描器
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
public class MyMapperScanner extends ClassPathBeanDefinitionScanner {
    public MyMapperScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    /**
     * 扫描条件更改为所有的接口
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
        return true;
    }

    /**
     * 替换扫描过程
     */
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> holders = super.doScan(basePackages);
        for (BeanDefinitionHolder holder : holders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) holder.getBeanDefinition();
            // 获取所有扫面到的mapper接口
            String beanClassName = beanDefinition.getBeanClassName();
            // 将bean类替换为我们自定义的FactoryBean
            beanDefinition.setBeanClass(MyAdvancedMybatisFactoryBean.class);
            // 注入属性
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
            // 配置自动注入 Sql会话工厂
            beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        }
        return holders;
    }
}
