package com.katus.mapper;

import com.katus.bean.my.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-07
 */
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User selectUserById(Long id);

    @Select("select * from user")
    List<User> list();
}
