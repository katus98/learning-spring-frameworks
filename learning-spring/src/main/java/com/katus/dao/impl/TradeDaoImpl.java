package com.katus.dao.impl;

import com.katus.dao.TradeDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-26
 */
@Repository(value = "tradeDao1")
public class TradeDaoImpl implements TradeDao {
    @Value(value = "0001")   // 直接加入值
    private String id;

    @Value(value = "54.8")
    private double price;

    @Override
    public void trade() {
        System.out.println(id + " Trading...");
        System.out.println("Price: " + price);
    }
}
