package com.ytn.elemonitoring.project.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		HttpSession session = request.getSession();
		
		
		log.info("loginUserName ====> {}", session.getAttribute("loginUserName"));
		
		if(session.getAttribute("loginUserId") == null){
			 response.sendRedirect("/ytn/researchInstutute/elections/login");
			 return false;
		}else {
			return true;
		}
	}
	
}
