package com.ytn.elemonitoring.project.ytnutil;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class YtnUtil {
	
	/**
	 * User Info Return
	 * 
	 * @author mattmk
	 * @param paramUser
	 * @return Map<String, String>
	 */
	public Map<String, String> getUserInfo(String paramUser){
		Map<String, String> resultMap = new HashMap<String,String>();
		
		if(paramUser == null || paramUser.isEmpty()) {
			return resultMap;
		}
		
		switch(paramUser) {
			case "user1" :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "�ŵ���");
				resultMap.put("userGender", "M");
				break;
			case "user2" :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "������");
				resultMap.put("userGender", "F");
				break;
			case "user3" :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "���ؼ�");
				resultMap.put("userGender", "M");
				break;
			case "user4" :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "�����");
				resultMap.put("userGender", "F");
				break;
			case "user5" :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "������");
				resultMap.put("userGender", "F");
				break;
			case "dev" :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "�׽�Ʈ");
				resultMap.put("userGender", "M");
				break;
			case "prod" :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "�");
				resultMap.put("userGender", "M");
				break;
			default :
				resultMap.put("userId", paramUser);
				resultMap.put("userName", "�׽�Ʈ");
				resultMap.put("userGender", "M");
				break;
		}
		
		return resultMap;
	}
}
