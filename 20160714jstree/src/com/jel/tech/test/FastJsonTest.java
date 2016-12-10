package com.jel.tech.test;

import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.alibaba.fastjson.JSONPath;
import com.jel.tech.entity.User;

public class FastJsonTest {

	@Test
	public void fun1() {
		
		User user = new User();
		user.setBirth(new Date());
		user.setId(101);
		user.setPassword("123456");
		user.setUserName("zhangSan");
		System.out.println(user);
		JSONObject jsonObject = JSONObject.fromObject(user);
		System.out.println(jsonObject.toString());
		
		Object bean = JSONObject.toBean(jsonObject);
		System.out.println(bean);
		
		JSONArray array = JSONArray.fromObject(user);
		System.out.println(array.toString());
		
		
	}
}
