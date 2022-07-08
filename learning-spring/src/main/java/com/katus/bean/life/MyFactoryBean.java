package com.katus.bean.life;

import com.katus.bean.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
@Component
@Slf4j
public class MyFactoryBean implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        log.info("{}-getObject()", this.getClass());
        return new Book("pro", "katus");
    }

    @Override
    public Class<?> getObjectType() {
        log.info("{}-getObjectType()", this.getClass());
        return Book.class;
    }
}
