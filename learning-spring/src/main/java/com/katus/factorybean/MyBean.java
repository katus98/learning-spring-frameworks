package com.katus.factorybean;

import com.katus.bean.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
public class MyBean implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        return new Book("Fire", "Sun");
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
