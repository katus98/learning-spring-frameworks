package com.katus.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-27
 */
@Component
@PropertySource(value = {"classpath:person.properties"})   // 如果指定从指定的配置文件中加载属性值
@ConfigurationProperties(prefix = "person")   // 将本类中的所有属性与全局配置文件中相关属性绑定
@Validated
public class Person {
    //@Value("ZhuYuan DaLao")
    private String lastName;
    //@Value("#{114514 * 2}")   // 支持SpEL表达式
    private Integer age;
    //@Value("${person.boss}")
    private Boolean boss;
    private Date birth;
    @Email   // 数据验证
    private String email;

    private Map<String, Object> map;
    private List<String> list;

    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public Date getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public List<String> getList() {
        return list;
    }

    public Dog getDog() {
        return dog;
    }
}
