package com.ytn.elemonitoring.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ytn/researchInstutute/elections")
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView loginForm(HttpServletRequest request) {

		ModelAndView  moduleAndView = new ModelAndView();
		moduleAndView.setViewName("/login.html");
		
		return moduleAndView;
	}
	
	@RequestMapping("/logout")
	public String viewLst(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// session √ ±‚»≠.
		session.invalidate();
		
		return "redirect:login";
	}
	
}
