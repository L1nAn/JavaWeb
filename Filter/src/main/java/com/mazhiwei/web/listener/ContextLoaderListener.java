package com.mazhiwei.web.listener; /**
 * @author 马治伟
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("加载资源");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁资源");
    }
}
