package com.katus.domain;

import java.io.Serializable;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-30
 */
public class User2 implements Serializable {
    private String username;
    private String password;
    private Integer age;

    public User2() {
    }

    public User2(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
