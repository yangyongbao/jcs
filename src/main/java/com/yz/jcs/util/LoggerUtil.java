package com.yz.jcs.util;


import java.text.MessageFormat;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志处理通用类
 * @author dongmj
 * @version $Id: LoggerUtil.java, v 0.1 2016年1月30日 下午3:51:56 dongmj Exp $
 */
public class LoggerUtil {
    /**
     * INFO日志
     * @param clazz 调用类
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void info(Class<?> clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix() + MessageFormat.format(format, args));
    }

    /**
     * INFO日志
     * @param clazz
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void info(String clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix() + MessageFormat.format(format, args));
    }
    
    /**
     * INFO日志 
     * @param clazz 调用类
     * @param message 日志内容
     */
    public static void info(Class<?> clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix() + message);
    }

    /**
     * INFO日志
     * @param clazz
     * @param message 日志内容
     */
    public static void info(String clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix() + message);
    }
    
    /**
     * INFO日志
     * @param clazz 调用类
     * @param cause 抛出的异常
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void info(Class<?> clazz, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix() + MessageFormat.format(format, args),  cause);
    }
    
    /**
     * INFO日志
     * @param clazz 调用类
     * @param cause 抛出的异常
     * @param message 日志内容
     */
    public static void info(Class<?> clazz, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isInfoEnabled())
            logger.info(logPrefix() + message, cause);
    }
    
    /**
     * DEBUG日志
     * @param clazz 调用类
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void debug(Class<?> clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix() + MessageFormat.format(format, args));
    }

    /**
     * DEBUG日志
     * @param clazz
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void debug(String clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix() + MessageFormat.format(format, args));
    }
    
    /**
     * DEBUG日志
     * @param clazz 调用类
     * @param message 消息内容
     */
    public static void debug(Class<?> clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix() + message);
    }

    /**
     * DEBUG日志
     * @param clazz
     * @param message 消息内容
     */
    public static void debug(String clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isDebugEnabled())
            logger.debug(logPrefix() + message);
    }
    
    /**
     * WARN日志
     * @param clazz 调用类
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void warn(Class<?> clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix() + MessageFormat.format(format, args));
    }

    /**
     * WARN日志
     * @param clazz
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void warn(String clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix() + MessageFormat.format(format, args));
    }
    
    /**
     * WARN日志
     * @param clazz 调用类
     * @param message 日志内容
     */
    public static void warn(Class<?> clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix() + message);
    }

    /**
     * WARN日志
     * @param clazz
     * @param message 日志内容
     */
    public static void warn(String clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix() + message);
    }
 
    /**
     * WARN日志
     * @param clazz 调用类
     * @param cause 抛出的异常
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void warn(Class<?> clazz, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix() + MessageFormat.format(format, args), cause);
    }
    
    /**
     * WARN日志
     * @param clazz 调用类
     * @param cause 抛出异常
     * @param message 日志内容
     */
    public static void warn(Class<?> clazz, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(logger.isWarnEnabled())
            logger.warn(logPrefix() + message, cause);
    }
    
    /**
     * ERROR日志
     * @param clazz 调用类
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void error(Class<?> clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + MessageFormat.format(format, args));
    }

    /**
     * ERROR日志
     * @param clazz
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void error(String clazz, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + MessageFormat.format(format, args));
    }
    
    /**
     * ERROR日志
     * @param clazz 调用类
     * @param message 日志内容
     */
    public static void error(Class<?> clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + message);
    }

    /**
     * ERROR日志
     * @param clazz 调用类
     * @param message 日志内容
     */
    public static void error(String clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + message);
    }
    
    /**
     * ERROR日志
     * @param clazz 调用类
     * @param cause 抛出的异常
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void error(Class<?> clazz, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + MessageFormat.format(format, args), cause);
    }

    /**
     * ERROR日志
     * @param clazz
     * @param cause 抛出的异常
     * @param format 日志格式，可以不包含参数
     * @param args 日志格式中包含的参数对应值
     */
    public static void error(String clazz, Throwable cause, String format, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + MessageFormat.format(format, args), cause);
    }
    
    /**
     * ERROR日志
     * @param clazz 调用类
     * @param cause 抛出异常
     * @param message 日志内容
     */
    public static void error(Class<?> clazz, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + message, cause);
    }

    /**
     * ERROR日志
     * @param clazz
     * @param cause 抛出异常
     * @param message 日志内容
     */
    public static void error(String clazz, Throwable cause, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(logPrefix() + message, cause);
    }
    
    private static ThreadLocal<String> identity = new ThreadLocal<String>() {

        /** 
         * @see java.lang.ThreadLocal#initialValue()
         */
        @Override
        protected String initialValue() {
            return UUID.randomUUID().toString();
        }
        
    };
    
    /**
     * 开始日志流程
     */
    public static void beginLog() {
        identity.set(UUID.randomUUID().toString());
    }
    
    /**
     * 多线程时，传入的唯一标识
     * @param uuid 唯一标识
     */
    public static void beginLog(String uuid) {
        identity.set(uuid);
    }
    
    /**
     * 停止日志流程
     */
    public static void endLog() {
        identity.remove();
    }
    
    private static String logPrefix() {
//        return "#UUID[" + identity.get() + "]#";
        return "";
    }
}
