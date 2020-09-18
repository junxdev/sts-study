package com.bit.sts06.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("preHandle");
		
//		if(request.getSession().getAttribute("login") == null) {
//			request.getRequestDispatcher("../home.jsp").forward(request, response); 
//			return false; 
//		}
		
		return super.preHandle(request, response, handler);
	}
	
	// mvc
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.debug("postHandle");
		log.debug(modelAndView.getModel().toString());
		log.debug(modelAndView.getViewName());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.debug("afterCompletion");
		if(ex != null) {
			log.debug(ex.getMessage());
			response.sendRedirect("add");
		}
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("afterConcurrentHandlingStarted");
	}
	
}
