package com.katus.aopanno;

import java.lang.annotation.*;

/**
 * 务必注意Spring AOP中使用的注解不能修饰接口乃至父类的方法, 必须直接修饰子类方法
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAsp {
    String value() default "";
}
