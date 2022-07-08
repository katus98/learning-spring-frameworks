package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
@Component
@Slf4j
public class JoinPoint {
    public void join() {
        log.info("{}-join()", this.getClass());
    }
}
