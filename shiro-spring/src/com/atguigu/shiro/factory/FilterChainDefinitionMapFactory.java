package com.atguigu.shiro.factory;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.shiro.service.PrevilegeService;

public class FilterChainDefinitionMapFactory {

	@Autowired
	private PrevilegeService prevService;
	
	public LinkedHashMap<String, String> initFilterChainDefinitionMap() {
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		/*map.put("/login.jsp", "anon");
		map.put("/shiro/login.do", "anon");
		map.put("/shiro/logout.do", "logout");
		
		map.put("/admin.jsp", "authc,roles[admin]");
		map.put("/user.jsp", "authc,roles[user]");
		map.put("/list.jsp", "user");
		map.put("/**", "authc");*/
		
//		[{visitUrl=/login.jsp, visitPrev=anon},....]
		List<LinkedHashMap<String, String>> initFilterChainDefMapList = prevService.initFilterChainDefinitionMap();
		
		Object[] array;
		for(LinkedHashMap<String, String> hmap : initFilterChainDefMapList) {
			array = hmap.values().toArray();
			map.put(array[0].toString(),array[1].toString());
		}
		return map;
	}
}
