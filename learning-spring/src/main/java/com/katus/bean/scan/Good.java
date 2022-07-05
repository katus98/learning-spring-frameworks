package com.katus.bean.scan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 */
@Component
@Slf4j
public class Good {
    public Good() {
        log.info("Good Cons...");
    }
}
