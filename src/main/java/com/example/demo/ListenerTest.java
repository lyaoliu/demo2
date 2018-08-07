package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/02 下午 3:42
 */
public class ListenerTest implements ServletContextListener {
    private static final Logger LOGGER= LogManager.getLogger();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("监听器初始化-------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("监听器销毁-------------");

    }
}
