package com.katus.config;

import java.lang.annotation.*;

/**
 * 自定义的Spring扫描注解
 * 增加@ComponentScan(includeFilters = @ComponentScan.Filter(classes = MyComponent.class, type = FilterType.ANNOTATION))使之生效
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyComponent {
}
