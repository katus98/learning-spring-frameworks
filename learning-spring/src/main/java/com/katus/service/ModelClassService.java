package com.katus.service;

import com.katus.bean.ModelClass;
import com.katus.dao.ModelClassDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
@Service
@Slf4j
public class ModelClassService {
    private final ModelClassDao modelClassDao;

    @Autowired
    public ModelClassService(ModelClassDao modelClassDao) {
        // 对象是通过jdk动态代理生成的
        // mybatis会根据接口动态代理生成一个代理对象
        this.modelClassDao = modelClassDao;
    }

    public List<ModelClass> queryAll() {
        return modelClassDao.queryAll();
    }
}
