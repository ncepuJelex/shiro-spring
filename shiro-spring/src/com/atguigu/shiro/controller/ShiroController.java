package com.atguigu.shiro.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.shiro.service.ShiroService;

@Controller
@RequestMapping("shiro")
public class ShiroController {

	private static final transient Logger logger = LoggerFactory.getLogger(ShiroController.class);
	
	@Autowired
	ShiroService service;
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(String username, String password) {
		
		/**get the currently executing user:*/
        Subject currentUser = SecurityUtils.getSubject();

        /**let's login the current user so we can check against roles and permissions:*/
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
            		logger.info("token's hashCode:{}", token.hashCode());
                currentUser.login(token);
            } catch (Exception e) {
            		logger.info("error msg:{}", e.getMessage());
            }
        }
		
		return "redirect:/list.jsp";
	}
	
	@RequestMapping("testShiroAnnotation.do")
	public String testShiroAnnotation(HttpSession session) {
		session.setAttribute("key", "value~~~");
		service.testShiroAnnotation();
		return "redirect:/list.jsp";
	}
	
}
