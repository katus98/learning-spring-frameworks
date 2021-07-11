package com.katus.bean;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
public class User {
    private String name;
    private int age;
    private String address;
    private String desc;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void add() {
        System.out.println("add...");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
