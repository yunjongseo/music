package com.netmusic.main.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.netmusic.main.service.NetMainService;

@Controller
public class NetMainController {
	Logger logger = Logger.getLogger(NetMainController.class);
	
	private NetMainService netMainService;
	
	// 생성자 오토와이어드
	@Autowired(required=false) 
	public NetMainController( NetMainService netMainService) { 
		this.netMainService =netMainService;
	}
	
	// 회원가입 입력 폼
	@GetMapping("mainpage")
	public String mainpage() {	
		logger.info("NetMainController mainpage() 진입 >>> : ");
		
		return "main/mainpage";
	}
}
