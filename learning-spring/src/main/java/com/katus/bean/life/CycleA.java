package com.katus.bean.life;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
@Component
@Slf4j
public class CycleA {
    private CycleB cycleB;

    public CycleA() {
        log.info("{}-Construction()", this.getClass());
    }

    @Autowired
    public void setCycleB(CycleB cycleB) {
        log.info("{}-setCycleB()", this.getClass());
        this.cycleB = cycleB;
    }
}
