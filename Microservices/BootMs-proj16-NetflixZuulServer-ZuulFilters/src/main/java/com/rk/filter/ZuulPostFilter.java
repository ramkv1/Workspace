package com.rk.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPostFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(ZuulPostFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulPostFilter.run()");
		//Create the RequestContext Object
		RequestContext context=RequestContext.getCurrentContext();
		//get request Object
		HttpServletResponse res=context.getResponse();
		//write log message to log file
		logger.info("Response status::"+res.getStatus());
		logger.info("Response cotent type::"+res.getContentType());
		logger.info("Host name::"+res.getHeader("host"));
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
