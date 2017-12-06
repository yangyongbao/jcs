package com.yz.jcs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.jcs.util.LoggerUtil;

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
			chain.doFilter(request, response);
		} finally {
			LoggerUtil.endLog();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
