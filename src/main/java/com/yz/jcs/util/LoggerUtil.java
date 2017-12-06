package com.yz.jcs.util;


import java.text.MessageFormat;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerUtil {
    
    public static void info(Class<?> clazz, String format ,String method, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }

    
    public static void info(String clazz, String format,String method, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }
    
    
    public static void info(Class<?> clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix(clazz,method) + message);
    }

    
    public static void info(String clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix(clazz,method) + message);
    }
    
   
    public static void info(Class<?> clazz,String method, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix(clazz,method) + MessageFormat.format(format, args),  cause);
    }
    
    
    public static void info(Class<?> clazz,String method, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix(clazz,method) + message, cause);
    }
    
    
    public static void debug(Class<?> clazz,String method, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }

    
    public static void debug(String clazz,String method, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }
    
    
    public static void debug(Class<?> clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix(clazz,method) + message);
    }

    
    public static void debug(String clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix(clazz,method) + message);
    }
    
   
    public static void warn(Class<?> clazz,String method, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }

    
    public static void warn(String clazz,String method, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }
    
    
    public static void warn(Class<?> clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix(clazz,method) + message);
    }

    
    public static void warn(String clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix(clazz,method) + message);
    }
 
    
    public static void warn(Class<?> clazz,String method, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix(clazz,method) + MessageFormat.format(format, args), cause);
    }
    
    
    public static void warn(Class<?> clazz,String method, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix(clazz,method) + message, cause);
    }
    
    
    public static void error(Class<?> clazz,String method, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }

    
    public static void error(String clazz,String method, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + MessageFormat.format(format, args));
    }
    
    
    public static void error(Class<?> clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + message);
    }

    
    public static void error(String clazz,String method, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + message);
    }
    
    
    public static void error(Class<?> clazz,String method, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + MessageFormat.format(format, args), cause);
    }

    
    public static void error(String clazz,String method, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + MessageFormat.format(format, args), cause);
    }
    
    public static void error(Class<?> clazz,String method, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + message, cause);
    }
    
    public static void error(String clazz,String method, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix(clazz,method) + message, cause);
    }
    
    private static ThreadLocal<String> identity = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return UUID.randomUUID().toString();
        }
    };
    
    public static void beginLog() {
        identity.set(UUID.randomUUID().toString());
    }
    
    
    public static void beginLog(String uuid) {
        identity.set(uuid);
    }
    
    
    public static void endLog() {
        identity.remove();
    }
    
    private static String logPrefix(Class<?> clazz,String method) {
        return "[" +  identity.get() + "]" + clazz.getClass().getName() + "." + method;
    }
    
    private static String logPrefix(String clazz,String method) {
        return "[" +  identity.get() + "]" + clazz + "." + method;
    }
}
