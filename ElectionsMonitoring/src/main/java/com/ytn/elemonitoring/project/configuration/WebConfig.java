package com.ytn.elemonitoring.project.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> loadList = new ArrayList<String>();
		loadList.add("/ytn/researchInstutute/elections/**");
		loadList.add("/**");
		
		List<String> notLoadList = new ArrayList<String>();
		
		notLoadList.add("/ytn/researchInstutute/elections/member/**");
		notLoadList.add("/ytn/researchInstutute/elections/login");
		notLoadList.add("/vendor/**");
		notLoadList.add("/js/**");
		notLoadList.add("/css/**");
		notLoadList.add("/img/**");
		
		// LoginInterceptor
		registry.addInterceptor(new LoginInterceptor())
				// ������ URL (��� URL�� ����)
				.addPathPatterns(loadList)
				// ������ URL (/login/������ ���� URL ����
				.excludePathPatterns(notLoadList);
	}
}
