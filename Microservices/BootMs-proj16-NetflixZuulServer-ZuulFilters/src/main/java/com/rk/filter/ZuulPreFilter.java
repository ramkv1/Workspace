package com.rk.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPreFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(ZuulPreFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulPreFilter.run()");
		//Create the RequestContext Object
		RequestContext context=RequestContext.getCurrentContext();
		//get request Object
		HttpServletRequest req=context.getRequest();
		//write log message to log file
		logger.info("Request method::"+req.getMethod());
		logger.info("Request URI::"+req.getRequestURI());
		logger.info("Request path::"+req.getServletPath());
		logger.info("Request Content type::"+req.getContentType());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
