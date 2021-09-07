package com.katus.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
public class Order implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private String id;
    private String desc;

    public Order() {   // life 第一步
        System.out.println("Bean.Constructor: Order");
    }

    public void setId(String id) {   // life 第二步
        System.out.println("Bean.setId: " + id);
        this.id = id;
    }

    public void setDesc(String desc) {
        System.out.println("Bean.setDesc: " + desc);
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public void initMethod() {   // life 第三步
        System.out.println("@PostConstruct > 实现InitializingBean接口方法 > init-method");
    }

    public void destroyMethod() {   // life 第五步
        System.out.println("@PreDestory > 实现的DisposableBean接口方法 > destroy-method");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware.setBeanName: " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware.setBeanFactory: " + beanFactory.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware.setApplicationContext: " + applicationContext.toString());
    }
}
