package com.mazhiwei.servlet;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author 马治伟
 * @version 1.0
 */
public class URLDemo {
   public static void main(String[] args) throws Exception{
      String name = "马治伟";
      String encode = URLEncoder.encode(name,"utf-8");
      System.out.println(encode);
      String decode = URLDecoder.decode(encode,"ISO-8859-1");
      System.out.println(decode);

      byte[] bytes = decode.getBytes("ISO-8859-1");

      for(byte b : bytes) {
         System.out.print(b + " ");
      }
      String s = new String(bytes, "utf-8");
      System.out.println(s);
   }
}
