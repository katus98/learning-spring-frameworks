package com.katus.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一个简易的切面实现
 * * 实际上Spring AOP如果自动开启切面的话, 会注册一个新的Bean后置处理器
 * * 这个Bean后置处理器会根据实际切面连接点涉及的类对这些Bean生成代理对象, 代理的实现根据切面逻辑来生成
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-04
 */
@Component
public class MyAopBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("需要被代理的Bean名称")) {   // 检查当前类是否包含切面的连接点
            Class<?> clazz = bean.getClass();
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new MyInvocationHandler(bean));
        }
        return bean;
    }

    @Slf4j
    public static class MyInvocationHandler implements InvocationHandler {
        private final Object object;

        public MyInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("Before...");
            Object obj = method.invoke(object, args);
            log.info("After...");
            return obj;
        }
    }
}
