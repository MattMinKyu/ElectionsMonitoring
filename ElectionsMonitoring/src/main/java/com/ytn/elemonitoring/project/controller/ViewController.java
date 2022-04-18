package com.ytn.elemonitoring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ytn/researchInstutute/elections/views")
public class ViewController {
	@RequestMapping("/index")
	public ModelAndView viewLst() {
		ModelAndView  moduleAndView = new ModelAndView();
		moduleAndView.setViewName("/index");
		moduleAndView.addObject("loginUserName", "±è¹Î±Ô´Ô");
		
		return moduleAndView;
	}
	
	@RequestMapping("/firstData")
	public ModelAndView getFirstDataList() {
		ModelAndView  moduleAndView = new ModelAndView();
		moduleAndView.setViewName("/firstData");
		
		return moduleAndView;
	}
}
