package com.ytn.elemonitoring.project.rest.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ytn.elemonitoring.project.ytnutil.YtnUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ytn/researchInstutute/elections/member/")
public class LoginRestController {
	private YtnUtil ytnUtil;
	
	public LoginRestController(YtnUtil ytnUtil) {
		this.ytnUtil = ytnUtil;
	}
	
	@RequestMapping("login")
	@ResponseBody
	public boolean getLogin(HttpServletRequest request, HttpServletResponse response) {
		boolean returnResult = Boolean.FALSE;
		String userSelect = request.getParameter("userSelect");
		
		if(userSelect == null || userSelect.isEmpty()) {
			return returnResult;
		}
		
		Map<String, String> userInfoMap = ytnUtil.getUserInfo(userSelect);
		
		log.info("======= getLogin() ====== [userInfoMap] : {}", userInfoMap);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("loginUserId", userInfoMap.get("userId"));
		session.setAttribute("loginUserName", userInfoMap.get("userName"));
    	session.setAttribute("loginUserGender", userInfoMap.get("userGender"));
    	returnResult = Boolean.TRUE;
		
		return returnResult;
	}
	
}
