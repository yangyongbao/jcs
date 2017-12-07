package com.yz.jcs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;


public class JsonUtil {
    private JsonUtil() {}
   
    public static String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }
    
    
    public static Map<String, String> toMap(String json) {
       return JSON.parseObject(json, new TypeReference<Map<String, String>>(){});
    }
    
    
    public static <T> T toObject(Class<T> dest, String json) {
    	if(null==json||json.equals("")) 
    		return null;
        return  JSON.parseObject(json, dest);
    }
    
   
    public static <T> List<T> toList(Class<T> dest, String json) {
        @SuppressWarnings("rawtypes")
		List list = JSON.parseObject(json, List.class);
        List<T> result = new ArrayList<T>();
        if (list == null || list.size() == 0) {
            return result;
        }
        for (Object obj : list) {
            result.add(JSON.parseObject(obj.toString(), dest));
        }
    	return result;
    }
    
    public static boolean validateJson(String source) {
    	try {
    		JSON.parse(source);    		
    	} catch(JSONException e) {
    		return false;
    	}
    	return true;
    }
    
   
}
