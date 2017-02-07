package com.atguigu.shiro.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface PrevilegeService {

	List<LinkedHashMap<String, String>> initFilterChainDefinitionMap();
}
