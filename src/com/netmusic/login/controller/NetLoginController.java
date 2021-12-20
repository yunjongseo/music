package com.netmusic.login.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netmusic.login.service.NetLoginService;
import com.netmusic.login.vo.NetLoginVO;
import com.netmusic.member.vo.NetMemberVO;

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
		logger.info("NetLoginController loginForm() 진입 >>> : ");
		
		return "login/loginForm";
	}
	
	@RequestMapping(value="loginMsg", method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpSession hs, NetLoginVO lvo, Model model) {
		logger.info("NetLoginController login() 진입 >>> : ");
		
		// 데이터가 바인딩된 객체에 담긴 내용 출력 
		// NetLoginVO.printVO(lvo);
		
		// ajax 데이터 리턴에 사용할 변수 선언
		String msg = "";
		//String mb_id = mvo.getMb_id();
		String mb_id = lvo.getMb_id();
		logger.info("로그인한 ID >>>> : " + mb_id);
		String mb_pw = lvo.getMb_pw();
		logger.info("로그인한 PW >>>> : " + mb_pw);
		
		// 세션에 세팅
		hs.setAttribute("resultList", lvo);
		// 리스트 세팅
		List<NetLoginVO> resultList = null;
		
		resultList = netLoginService.loginCheck(lvo);
		System.out.println("resultList >>> : DB에서 리턴된 리스트의 사이즈를 출력합니다 : " + resultList.size());

		if (resultList.size() > 0) {

			msg = "success";

			
		} else if (resultList.size() == 0) {
			System.out.println("DB에서 받아온 데이터가 없습니다. >>> : 아이디와 비밀번호를 다시 입력해주세요.");
			
			msg = "fail";

		}
		return msg;
	}
	
	@GetMapping("good")
	public String good() {
		logger.info("NetLoginController good() 진입 >>> : ");
		
		return "login/good";
	}
}
