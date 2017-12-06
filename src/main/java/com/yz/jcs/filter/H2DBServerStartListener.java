package com.yz.jcs.filter;


import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

import com.yz.jcs.util.LoggerUtil;

	
public class H2DBServerStartListener implements ServletContextListener {

    private Server server;
    
    public void contextInitialized(ServletContextEvent sce) {
        try {
        	LoggerUtil.info(getClass(),"contextInitialized", "正在启动h2数据库...");
            server = Server.createTcpServer().start(); 
            LoggerUtil.info(getClass(),"contextInitialized", "h2数据库启动成功...");
        } catch (SQLException e) {  
        	LoggerUtil.error(getClass(),"contextInitialized", e, "启动h2数据库出错：" );
            throw new RuntimeException(e);  
        }  
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        if (this.server != null) {
        	LoggerUtil.info(getClass(),"contextDestroyed", "正在关闭h2数据库...");
            this.server.stop();
            LoggerUtil.info(getClass(),"contextDestroyed", "h2数据库关闭成功...");
            this.server = null;
        }
    }
}
