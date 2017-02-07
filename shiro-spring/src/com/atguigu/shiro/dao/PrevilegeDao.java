package com.atguigu.shiro.dao;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * initial previlege infos from db
 * @author zhenhua
 *
 */
public interface PrevilegeDao {

	List<LinkedHashMap<String, String>> getFilterChainDefinitionMap();
}
