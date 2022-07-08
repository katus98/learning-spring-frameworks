package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
@Component
@Slf4j
public class Member {
    public Member() {
        log.info("{}-Construction", this.getClass());
    }
}
