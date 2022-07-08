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
public class CycleB {
    private CycleA cycleA;

    public CycleB() {
        log.info("{}-Construction()", this.getClass());
    }

    @Autowired
    public void setCycleA(CycleA cycleA) {
        log.info("{}-setCycleA()", this.getClass());
        this.cycleA = cycleA;
    }
}
