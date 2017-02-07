package com.atguigu.shiro.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.shiro.dao.PrevilegeDao;
import com.atguigu.shiro.service.PrevilegeService;

@Service("previlegeService")
public class PrevilegeServiceImpl implements PrevilegeService {

	@Autowired
	private PrevilegeDao prevDao;
	
	@Override
	public List<LinkedHashMap<String, String>> initFilterChainDefinitionMap() {
		return prevDao.getFilterChainDefinitionMap();
	}
	
}
