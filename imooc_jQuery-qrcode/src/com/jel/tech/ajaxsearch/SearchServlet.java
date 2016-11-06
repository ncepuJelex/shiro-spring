package com.jel.tech.ajaxsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static List<String> sqlData = new ArrayList<String>();
	static {
		sqlData.add("Jelex");
		sqlData.add("CR7");
		sqlData.add("Cristiano Ronaldo");
		sqlData.add("C罗");
		sqlData.add("C罗纳尔多");
		sqlData.add("小小罗");
		sqlData.add("Java");
		sqlData.add("javascript");
		sqlData.add("Java Concurrency Programming");
		sqlData.add("MacBook");
		sqlData.add("MacBook Air");
		sqlData.add("MacBook Pro");
		sqlData.add("new MacBook");
		sqlData.add("ajax");
		sqlData.add("jquery");
		sqlData.add("徐经贵");
		sqlData.add("徐振华");
		sqlData.add("徐紫凤");
		sqlData.add("徐宗衡");
		sqlData.add("徐锦江");
		sqlData.add("林则徐");
		sqlData.add("北京");
		sqlData.add("上海");
		sqlData.add("广州");
		sqlData.add("深圳");
		sqlData.add("杭州");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String keywords = request.getParameter("keywords");
		
		List<String> result = getContents(keywords);
		
		ObjectMapper mapper = new ObjectMapper();
		String resultStr = mapper.writeValueAsString(result);
		response.getWriter().write(resultStr);
	}

	private List<String> getContents(String keywords) {
		if(keywords==null || keywords.trim().isEmpty()) {
			return Collections.emptyList();
		}
		List<String> results = new ArrayList<>();
		for(String s : sqlData) {
			if(s.toLowerCase().contains(keywords.toLowerCase())) {
				results.add(s);
			}
		}
		return results;
	}

}
