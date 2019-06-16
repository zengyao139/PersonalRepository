package com.zengyao.fliter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckFilter implements Filter {  
	  protected FilterConfig filterConfig = null;  
	  private String redirectURL = null;  
	  private Set<String> notCheckURLList = new HashSet<String>();  
	  private String sessionKey = null;  
	  @Override  
	  public void destroy() {  
	    notCheckURLList.clear();  
	  }  
	  @Override  
	  public void doFilter(ServletRequest servletRequest,  
	      ServletResponse servletResponse, FilterChain filterChain)  
	      throws IOException, ServletException {  
		/*  System.out.println("SessionCheckFilter.doFilter()");*/
	    HttpServletRequest request = (HttpServletRequest) servletRequest;  
	    
	    HttpServletResponse response = (HttpServletResponse) servletResponse;  
	    HttpSession session = request.getSession();  
	    if (sessionKey == null) {  
	      filterChain.doFilter(request, response);  
	      return;  
	    }  
	    if ((!checkRequestURIIntNotFilterList(request))  
	        && session.getAttribute("user") == null) {  
	         response.sendRedirect(request.getContextPath() + redirectURL);  
	      return;  
	    }  
	    filterChain.doFilter(servletRequest, servletResponse);  
	  }  
	  private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {  
	    String uri = request.getServletPath()  
	        + (request.getPathInfo() == null ? "" : request.getPathInfo());  
	    String temp = request.getRequestURI();
	    temp = temp.substring(request.getContextPath().length() + 1);  
	    // System.out.println("是否包括："+uri+";"+notCheckURLList+"=="+notCheckURLList.contains(uri));  
	    return notCheckURLList.contains(uri);  
	  }  
	  @Override  
	  public void init(FilterConfig filterConfig) throws ServletException {  
		  //日志文件
		//  System.out.println("SessionCheckFilter.init()");
	    this.filterConfig = filterConfig;  
	    redirectURL = filterConfig.getInitParameter("redirectURL");  
	    sessionKey = filterConfig.getInitParameter("checkSessionKey");  
	    String notCheckURLListStr = filterConfig  
	        .getInitParameter("notCheckURLList");  
	    if (notCheckURLListStr != null) {  
	     // System.out.println(notCheckURLListStr);  
	      String[] params = notCheckURLListStr.split(",");  
	      for (int i = 0; i < params.length; i++) {  
	        notCheckURLList.add(params[i].trim());  
	      }  
	    }
	    /*System.out.println("sessionkey: "+sessionKey);
	    System.out.println("redirect: "+redirectURL);
	    System.out.println("notcheckURLLISts: "+notCheckURLListStr);*/
	  }  
	} 