package com.rk.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulRouteFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(ZuulRouteFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulRouteFilter.run()");
		//Create the RequestContext Object
		RequestContext context=RequestContext.getCurrentContext();
		//write Route host info log file
		logger.info("Route host name::"+context.getRouteHost());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
