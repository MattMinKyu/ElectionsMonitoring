package com.ytn.elemonitoring.project.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRoutingDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        
        log.info("request.getRequestURI() [request] ===> {}", request.getRequestURI());
        
        String[] uriSplitArr = request.getRequestURI().split("/");
        
        String returnTarget = uriSplitArr[5];
        
        log.info("request.getRequestURI() [returnTarget] ===> {}", returnTarget);
         
        if(returnTarget.contains("user") || returnTarget.contains("dev") || returnTarget.contains("prod")) {
        	return returnTarget;
        }else {
        	return "";
        }
        
        
        /*
        if (request.getRequestURI().startsWith("/user1")) {
            return "user1";
        } else {
            return "user2";
        }
        */	
	}
}
