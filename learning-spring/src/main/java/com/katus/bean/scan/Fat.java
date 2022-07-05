package com.katus.bean.scan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 另外Spring默认扫描还支持@ManagedBean与@Named注解
 * 但是这两个注解不是Spring内置的, 而是通用其他包中的通用Java注解
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
//@ManagedBean
//@Named
@Component
@Slf4j
public class Fat {
    public Fat() {
        log.info("Fat Cons...");
    }
}
