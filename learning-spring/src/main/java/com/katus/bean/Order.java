package com.katus.bean;

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-25
 */
public class Order {
    private String id;
    private String desc;

    public Order() {   // life 第一步
        System.out.println("Con run...");
    }

    public void setId(String id) {   // life 第二步
        System.out.println("Set id...");
        this.id = id;
    }

    public void setDesc(String desc) {
        System.out.println("Set desc...");
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public void initMethod() {   // life 第三步
        System.out.println("Init run...");
    }

    public void destroyMethod() {   // life 第五步
        System.out.println("Destroy run...");
    }
}
