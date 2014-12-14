package com.mycompany;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

public class RequestIdLoggingFilter implements Filter {

	static final Logger logger = LogManager.getLogger(RequestIdLoggingFilter.class.getName());

	@Override public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		if (servletRequest instanceof HttpServletRequest) {
			String xRequestId = UUID.randomUUID().toString().replace("-", "");;
			ThreadContext.put("X-Request-ID", xRequestId);
			logger.error("Inside filter");
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override public void destroy() {

	}
}
