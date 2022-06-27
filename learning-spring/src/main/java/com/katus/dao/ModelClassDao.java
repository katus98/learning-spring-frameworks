package com.katus.dao;

import com.katus.bean.ModelClass;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
public interface ModelClassDao {
    @Select("select * from wf_model_class")
    List<ModelClass> queryAll();
}
