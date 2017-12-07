package com.yz.jcs.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.jcs.util.JsonUtil;
import com.yz.jcs.util.LoggerUtil;
import com.yz.jcs.util.ThreadLocalUtil;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain)
			throws IOException, ServletException {
		LoggerUtil.beginLog();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		String url = request.getServletPath();
		LoggerUtil.info(getClass(), "doFilter", url);
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("requestId", UUID.randomUUID()+"");
			ThreadLocalUtil.set(map);
			chain.doFilter(request, response);
			System.out.println(JsonUtil.toJson(ThreadLocalUtil.get()));
		} finally {
			ThreadLocalUtil.clear();
			LoggerUtil.endLog();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
