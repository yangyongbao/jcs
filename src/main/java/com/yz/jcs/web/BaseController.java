/**
 * 
 */
package com.yz.jcs.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.web.servlet.View;

import com.yz.jcs.util.ResultEnum;
import com.yz.jcs.view.JsonpView;


public class BaseController {
	
	protected View successView(Object result) {
		return view(true, ResultEnum.SUCCESS.code(), "", result);
	}

	protected View successView(String msg, Object result) {
		return view(true, ResultEnum.SUCCESS.code(), msg, result);
	}

	protected View failureView() {
		return view(false, ResultEnum.SERVER_ERROR.code(), ResultEnum.SERVER_ERROR.msg(), null);
	}

	protected View failureView(String msg) {
		return view(false, ResultEnum.SERVER_ERROR.code(), msg, null);
	}
	
    protected View failureView(ResultEnum code) {
        return view(false, code.code(), code.msg(), null);
    }
    
	protected View failureView(ResultEnum code, String msg) {
		return view(false, code.code(), msg, null);
	}

	protected View failureView(int code, String msg) {
		return view(false, code, msg, null);
	}
	
	protected View failureView(int code, String msg, Object data) {
		return view(false, code, msg, data);
	}

	private View view(boolean success, int code, String msg, Object data) {
		JSONObject json = new JSONObject();
		json.put("success", success);
		json.put("code", code);
		json.put("msg", msg);
		json.put("timestamp", System.currentTimeMillis());
		json.put("resultObject", data);
		return jsonpView(json);
	}

	private View jsonpView(Object responseData) {
		return new JsonpView(JSONObject.valueToString(responseData));
	}
	
	public static Map<String, String> getRequestMap(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			paramValue = paramValue == null ? "" : paramValue;
			params.put(paramName, paramValue);
		}
		return params;
	}
	
}
