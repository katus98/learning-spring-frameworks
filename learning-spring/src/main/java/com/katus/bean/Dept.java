package com.katus.bean;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
public class Dept {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
