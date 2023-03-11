package com.mazhiwei.service;


import com.mazhiwei.mapper.UserMapper;
import com.mazhiwei.pojo.User;
import com.mazhiwei.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



/**
 * @author 马治伟
 * @version 1.0
 */
public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username,String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }
}
