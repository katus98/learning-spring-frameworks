package com.katus.service;

import com.katus.dao.TradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
@Service
@Transactional   // 本类所有的方法全部使用事务管理 该注解也可以标在方法上表示方法是事务管理的
// @Transactional(propagation = Propagation.REQUIRED)   // 传播行为 规定事务的嵌套 共有七种枚举
// @Transactional(isolation = Isolation.SERIALIZABLE)   // 隔离级别 解决脏读 不可重复读 虚读 的问题
// @Transactional(timeout = 5)   // 超时时间 默认-1 单位是秒
// @Transactional(readOnly = true)   // 是否只读 默认false 只读指只能进行查询操作 不能增删改
// @Transactional(rollbackFor = {IOException.class})   // 出现什么异常即回滚
// @Transactional(noRollbackFor = {IOException.class})   // 出现什么异常不回滚
public class TradeService {
    @Autowired   // 按照属性自动装配对象 不需要set方法
    // @Resource   // 按照属性自动装配对象 与@Autowired一致 非Spring提供 不建议使用
    @Qualifier(value = "tradeDao1")   // 按照名称自动装配 不需要set方法
    // @Resource(name = "tradeDao1")   // 按照名称自动装配 与@Qualifier(value = "tradeDao1")一致 非Spring提供 不建议使用
    private TradeDao tradeDao;

    public void start() {
        tradeDao.trade();
    }
}
