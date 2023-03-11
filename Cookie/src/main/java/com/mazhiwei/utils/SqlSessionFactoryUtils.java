package com.mazhiwei.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author 马治伟
 * @version 1.0
 */
public class SqlSessionFactoryUtils {
   private static SqlSessionFactory sqlSessionFactory;

   static {
      String resource = "mybatis-config.xml";
      try {
         InputStream inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
   public static SqlSessionFactory getSqlSessionFactory() {
      return sqlSessionFactory;
   }
}
