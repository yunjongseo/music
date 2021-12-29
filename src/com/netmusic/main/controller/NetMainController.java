package com.netmusic.main.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

import com.netmusic.main.service.NetMainService;
import com.netmusic.member.service.NetMemberService;
import com.netmusic.member.vo.NetMemberVO;
import com.netmusic.music.service.NetMusicService;
import com.netmusic.music.vo.NetMusicVO;

@Controller
public class NetMainController {
	Logger logger = Logger.getLogger(NetMainController.class);
	
	private NetMainService netMainService;
	private NetMemberService netMemberService;
	private NetMusicService netMusicService;
	
	// 생성자 오토와이어드
	@Autowired(required=false) 
	public NetMainController( NetMainService netMainService,
							  NetMemberService netMemberService,
							  NetMusicService netMusicService) { 
		this.netMainService =netMainService;
		this.netMemberService =netMemberService;
		this.netMusicService =netMusicService;
	}
	
	// 회원가입 입력 폼
	/*
	 * @GetMapping("mainpage") public String mainpage() {
	 * logger.info("NetMainController mainpage() 진입 >>> : ");
	 * 
	 * return "main/mainpage"; }
	 */
	
	// 카카오페이
	@RequestMapping("kakao")
	@ResponseBody
	public String kakao() throws MalformedURLException {
		logger.info("NetMainController kakao() 진입 >>> : ");
		
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection hurl = (HttpURLConnection) address.openConnection(); 
			hurl.setRequestMethod("POST");
			hurl.setRequestProperty("Authorization", "KakaoAK a07fbfff7871a297fafa5370a3182c2d");
			hurl.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			hurl.setDoOutput(true);
			String param = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=초코파이&quantity=1&total_amount=2200&tax_free_amount=0&approval_url=https://localhost:8088/success&cancel_url=https://localhost:8088/cancel&fail_url=https://localhost:8088/fail";
			OutputStream bound = hurl.getOutputStream();
			DataOutputStream databd = new DataOutputStream(bound);
			databd.writeBytes(param);
			databd.close();
			
			int result = hurl.getResponseCode();
			
			InputStream is;
			if(result == 200) {
				is = hurl.getInputStream();
			}else {
				is = hurl.getErrorStream();
			}
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			return bfr.readLine();
		}catch(Exception e) {
			System.out.println("결제 에러 >>> : " + e);
		}
		return "";
	}
	
	// 회원 전체 조회
	@RequestMapping(value="mainpage", method=RequestMethod.GET)
	public String mainpage(HttpServletRequest req, NetMemberVO mvo, Model model, HttpSession hs) {
		logger.info("NetMainController mainpage() 진입 >>> : ");
		
		logger.info("NetMainController mainpage() 진입 >>> : "
				+ "검색 관련 로그 ==========");
		logger.info("NetMainController mainpage Keyfilter >>> : " 
						+ req.getParameter("second"));
		logger.info("NetMainController mainpage mvo.getKeyword() >>> : " 
						+ mvo.getKeyword());
		
		String second = req.getParameter("second");
		
		try {
			if(second.equals("key1") || second.equals("key2")) {
				// 로그인한 회원 아이디 세션으로 불러오기
				NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
				String my_id = mvo_data.getMb_id();
				logger.info("NetMainController mainpage my_id >>> : " + my_id);
				
				mvo.setKeyfilter(second);
				mvo.setMy_id(my_id);

				List<NetMemberVO> listAll = netMemberService.memberSelectAll(mvo);
				logger.info("NetMainController mainpage listAll.size() >>> : " 
							+ listAll.size());
					
				model.addAttribute("listAll", listAll);
				return "main/mainpage";
			}else {
				NetMusicVO mvo_ = new NetMusicVO();
				
				mvo_.setKeyfilter(second);
				mvo_.setKeyword(mvo.getKeyword());
				
				List<NetMusicVO> mlistAll = netMusicService.musicSelectAll(mvo_);
				logger.info("NetMainController mainpage mlistAll.size() >>> : " 
						+ mlistAll.size());
				
				model.addAttribute("mlistAll", mlistAll);
				return "main/mainpage";
			}
		}catch(Exception e) {
		}
		return "main/mainpage";
	}
}
