package com.rk.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulErrorFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(ZuulErrorFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulErrorFilter.run()");
		//Create the RequestContext Object
		RequestContext context=RequestContext.getCurrentContext();
		//get request Object
		Throwable th=context.getThrowable();
		//write log message to log file
		logger.info("======Error Filter");
		logger.info("Error/Problem is::"+th.getMessage()+" Exception class name"+th);
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
