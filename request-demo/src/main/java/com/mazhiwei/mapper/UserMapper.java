package com.mazhiwei.mapper;

import com.mazhiwei.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 马治伟
 * @version 1.0
 */
public interface UserMapper {
    User selectById(@Param("username") String username, @Param("password") String password);


    User selectByUserName(@Param("username") String username);

    void insert(User user);
}
