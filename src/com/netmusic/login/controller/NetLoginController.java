package com.netmusic.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netmusic.common.NaverMail;
import com.netmusic.common.PasswordUtil;
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
	
	// 로그인
	@RequestMapping(value="loginMsg", method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpSession hs, NetMemberVO mvo) {
		logger.info("NetLoginController login() 진입 >>> : ");
		
		// ajax 데이터 리턴에 사용할 변수 선언
		String msg = "";

		String mb_id = mvo.getMb_id();
		logger.info("로그인한 ID >>>> : " + mb_id);
		String mb_pw = mvo.getMb_pw();
		logger.info("로그인한 PW >>>> : " + mb_pw);
		
		// 리스트 세팅
		List<NetMemberVO> resultList = null;
		
		resultList = netLoginService.loginCheck(mvo);
		logger.info("resultList >>> : DB에서 리턴된 리스트의 사이즈를 출력합니다 : " + resultList.size());

		if (resultList.size() > 0) {
			
			NetMemberVO mvo_ = new NetMemberVO();
			mvo_ = resultList.get(0);
			
			// 세션에 세팅
			hs.setAttribute("result", mvo_);
			
			msg = "success";
		} else if (resultList.size() == 0) {
			logger.info("DB에서 받아온 데이터가 없습니다. >>> : 아이디와 비밀번호를 다시 입력해주세요.");
			
			msg = "fail";
		}
		return msg;
	}
	
	// 로그인 성공 -> 회원 전체 조회로
	@GetMapping("loginsuccess")
	public String loginsuccess() {
		logger.info("NetLoginController loginsuccess() 진입 >>> : ");
		
		return "login/loginsuccess";
	}
	
	// 로그아웃
	
	// 이메일로 아이디 찾기 입력 폼
	@GetMapping("idFindForm")
	public String idFind() {
		logger.info("NetLoginController idFindForm() 함수 진입 >>> : ");
		
		return "login/idFindForm";
	}
	
	// 아이디 찾기
	@GetMapping("idFind")
	public String idFind(NetMemberVO mvo, 
						 HttpServletRequest req,
						 Model model) {
		logger.info("NetLoginController idFind() 진입 >>> : ");
		
		// 이름
		String mb_name = req.getParameter("mb_name");
		mvo.setMb_name(mb_name);
		// 생년월일
		String mb_birth = req.getParameter("mb_birth");
		String mb_birth1 = req.getParameter("mb_birth1");
		String mb_birth2 = req.getParameter("mb_birth2");
		mb_birth = mb_birth + mb_birth1 + mb_birth2;
		mvo.setMb_birth(mb_birth);
		// 핸드폰
		String mb_hp = req.getParameter("mb_hp");
		mvo.setMb_hp(mb_hp);
		
		logger.info("NetLoginController idFind mb_name >>> : " + mb_name);
		logger.info("NetLoginController idFind mb_birth >>> : " + mb_birth);
		logger.info("NetLoginController idFind mb_hp >>> : " + mb_hp);
		
		List<NetMemberVO> listid = netLoginService.idCheck(mvo);
		logger.info("NetLoginController idFind "
				+ "listid.size() >>> : " + listid.size());
	
		// 이메일이 확인되면 인증번호를 이메일로 인증번호 리턴하기
		if(listid.size() != 0) {
			
			model.addAttribute("listid", listid);
			return "login/idFindList";
		}
		return "login/";
	}
	
	// 비밀번호 찾기 입력 폼
	@GetMapping("pwFindForm")
	public String pwFindForm() {
		logger.info("NetLoginController pwFindForm() 함수 진입 >>> : ");
		
		return "login/pwFindIdForm";
	}
	
	// 아이디 체크
	@GetMapping("pwTempCheck")
	public String pwIdCheck(NetMemberVO mvo, NetLoginVO lvo, Model model) {
		logger.info("SpringLoginController pwIdCheck() 함수 진입 >>> : ");
		
		NetMemberVO.printVO(mvo);
		NetLoginVO.printVO(lvo);
		
		List<NetMemberVO> listPwId = netLoginService.pwIdCheck(mvo);
		logger.info("SpringLoginController pwIdCheck listPwId.size() >>> : "
				+ listPwId.size());
		
		if(listPwId.size() == 1) {
			
			// 임시 비밀번호(8자) 만들기
			String temp_pw_num = PasswordUtil.randomPW(8);
			logger.info("SpringLoginController id_authentication temp_pw_num >>> : "
					+ temp_pw_num);
			
			// 임시 비밀번호 TEMP_PW 테이블에 입력하기
			lvo.setPtemppw(temp_pw_num);
			int tempPwCnt = netLoginService.tempPwInsert(lvo);
			logger.info("SpringLoginController id_authentication tempPwCnt >>> : "
					+ tempPwCnt);
			
			// 멤버 테이블 비밀번호 데이터 임시 비밀번호로 업데이트
			mvo.setMb_pw(temp_pw_num);
			// int pwUp = netLoginService.pwUpdate(mvo);
			netLoginService.pwUpdate(mvo);
			
			// 입력 성공하면 임시 비밀번호 이메일 보내기
			// 메일 성공 여부는 ???
			if(tempPwCnt == 1) {
				
				// TEMP_AUTH_NUM 테이블에 입력 성공된 인증번호로 메일 보내기
				temp_pw_num = lvo.getPtemppw();
				String mb_email = mvo.getMb_email();
				
				String mailSubject = "임시 비밀번호";
				String sendMail = "netmusic93@naver.com";
				String sendPw = "sptabwlr93";
				String reciveMail = mb_email;
				String sendMsg= temp_pw_num;
				
				NaverMail nm = new NaverMail();
				nm.naverMail(mailSubject, sendMail, sendPw, reciveMail, sendMsg);
				
				// idFind에 메시지 띄우기
				model.addAttribute("temp_pw_num", temp_pw_num);
					
				return "login/pwsuccess";
			}
		}
		return "login/pwFindIdForm";
	}
}
