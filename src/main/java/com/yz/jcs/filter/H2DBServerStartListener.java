package com.yz.jcs.filter;


import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

	
public class H2DBServerStartListener implements ServletContextListener {

    private Server server;
    
    public void contextInitialized(ServletContextEvent sce) {
        try {  
            System.out.println("正在启动h2数据库...");
            server = Server.createTcpServer().start(); 
            System.out.println("h2数据库启动成功...");
        } catch (SQLException e) {  
            System.out.println("启动h2数据库出错：" + e.toString());  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }  
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        if (this.server != null) {
        	System.out.println("正在关闭h2数据库...");
            this.server.stop();
            System.out.println("h2数据库关闭成功...");
            this.server = null;
        }
    }
}
