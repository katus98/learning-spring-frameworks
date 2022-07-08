package com.katus.mybatis.mapper;

import com.katus.mybatis.bean.User;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-07
 */
public interface UserMapper {
    User selectUserById(Long id);
}
