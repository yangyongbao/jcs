package com.yz.jcs.util;

import java.util.Map;


public class ThreadLocalUtil {
	
	
    private static final ThreadLocal<Map<String, String>> SESSION_USER = new ThreadLocal<Map<String, String>>();

    
    public static void set(Map<String, String> map) {
        SESSION_USER.set(map);
    }

    
    public static Map<String, String> get() {
        return SESSION_USER.get();
    }

    public static void clear() {
        SESSION_USER.remove();
    }
    

}
