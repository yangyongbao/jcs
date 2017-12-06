package com.yz.jcs.view;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseHelper {
	public final static String MT_JSONP = "application/x-javascript";
	public final static String MT_JSON = "application/json";
	public final static String MT_TEXT = "text/plain";
	
	/**
	 * @deprecated 
	 * @param res
	 * @param message
	 * @param encode
	 * @throws IOException
	 */
    public static void send(HttpServletRequest request,HttpServletResponse res, String message, String encode) throws IOException {
    	send(request,res, message, MT_TEXT, encode);
    }
   
    /**
     * @param res
     * @param message
     * @param mediaType
     * @param encode
     * @throws IOException
     */
    public static void send(HttpServletRequest request,HttpServletResponse res, String message, String mediaType, String encode) throws IOException {
    	byte[] result = null;
    	if (encode != null) {
            result = message.getBytes(encode);
            res.setContentType(mediaType + "; charset=" + encode);
    	} else {
            result = message.getBytes();
            res.setContentType(mediaType + "; charset=ISO8859_1");
    	}
    	String ie = request.getHeader( "User-Agent");
    	//ie使用jsonp必须这样设置
        if(ie!=null && ie.contains("MSIE 6.0")){
        	 res.setHeader("Pragma", "public");
             res.setDateHeader("Expires", System.currentTimeMillis()+1000);
             res.addHeader("Cache-Control", "maxage=1"); 
        }else{
	          res.setHeader("Pragma", "no-cache");
	          res.setDateHeader("Expires", 0);
	          res.addHeader("Cache-Control", "must-revalidate, no-cache, no-store"); 
        } 
        res.setContentLength(result.length);
        res.getOutputStream().write(result);

        res.flushBuffer();
    }

}

