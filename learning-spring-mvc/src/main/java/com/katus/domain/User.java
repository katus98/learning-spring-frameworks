package com.katus.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-29
 */
public class User implements Serializable {
    private String name;
    private Integer age;

    private Date date;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
