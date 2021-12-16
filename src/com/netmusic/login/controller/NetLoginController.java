package com.netmusic.login.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.netmusic.login.service.NetLoginService;

@Controller
public class NetLoginController {
	Logger logger = Logger.getLogger(NetLoginController.class);
	
	private NetLoginService netLoginService;
	
	// 생성자 오토와이어드
	@Autowired(required=false)
	public NetLoginController(NetLoginService netLoginService) {
		this.netLoginService = netLoginService;
	}
	
	// 로그인 입력 폼
	@GetMapping("loginForm")
	public String loginForm() {
		logger.info("NetLoginController loginForm() 함수 진입 >>> : ");
		
		return "login/sprinzLoginForm";
	}
}
