package com.devglan.config;


import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;

import com.netflix.zuul.ZuulFilter;

@Component
public class CustomPostZuulFilter extends ZuulFilter {
    //...
    @Override
    public Object run() {
        //...
    	
    	
    	 RequestContext ctx = RequestContext.getCurrentContext();
    	 HttpServletRequest request = ctx.getRequest();
    	
        String requestMethod = request.getMethod();
        if ( request.getRequestURI().contains("oauth/token") && requestMethod.equals("DELETE")) {
            Cookie cookie = new Cookie("refreshToken", "");
            cookie.setMaxAge(0);
            cookie.setPath(ctx.getRequest().getContextPath() + "/oauth/token");
            ctx.getResponse().addCookie(cookie);
        }
      return null;  
    }

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
}
