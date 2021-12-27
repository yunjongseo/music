package com.netmusic.follow.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netmusic.follow.service.NetFollowService;
import com.netmusic.follow.vo.NetFollowVO;
import com.netmusic.member.vo.NetMemberVO;

@Controller
public class NetFollowController {
	Logger logger = Logger.getLogger(NetFollowController.class);
	
	private NetFollowService netFollowService;
	
	// 생성자 오토와이어드 
	@Autowired(required=false)	
	public NetFollowController( NetFollowService netFollowService) {
		this.netFollowService = netFollowService;
	}
	
	// 팔로우 리스트
	@RequestMapping(value="followlist", method=RequestMethod.GET)
	public String followList(NetFollowVO fvo, Model model, HttpSession hs) {
		logger.info("NetFollowController followlist() 진입 >>> : ");
		
		// 세션에 있는 회원 아이디를 받음 -> mb_id 저장
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String mb_id = mvo_data.getMb_id();
		String mb_name = mvo_data.getMb_name();
		
		logger.info("NetFollowController followlist mb_id >>> : " + mb_id);
		logger.info("NetFollowController followlist mb_name >>> : " + mb_name);
		
		// 뷰 페이지에 회원 이름 표시하기 위한 데이터
		model.addAttribute("mb_name", mb_name);
				
		// 세션에서 받아온 id -> NetFollowVO에 담기
		fvo.setMb_id(mb_id);
		
		List<NetFollowVO> listS = netFollowService.followList(fvo);
		logger.info("NetFollowController followlist listS.size() >>> : " +
		listS.size());
		
		if(listS.size() != 0) {
			model.addAttribute("listS", listS);
			return "follow/followlist";
		}
		return "follow/followlistzero";
	}
	
	// 팔로워 리스트
	@RequestMapping(value="followerlist", method=RequestMethod.GET)
	public String followerlist(NetFollowVO fvo, Model model, HttpSession hs) {
		logger.info("NetFollowController followerlist() 진입 >>> : ");
		
		// 세션에 있는 회원 아이디를 받음 -> mb_id 저장
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String mb_id = mvo_data.getMb_id();
		String mb_name = mvo_data.getMb_name();
		
		logger.info("NetFollowController followerlist mb_id >>> : " + mb_id);
		logger.info("NetFollowController followerlist mb_name >>> : " + mb_name);
		
		// 뷰 페이지에 회원 이름 표시하기 위한 데이터
		model.addAttribute("mb_name", mb_name);
				
		// 세션에서 받아온 id -> NetFollowVO에 담기
		fvo.setMb_id(mb_id);
		
		List<NetFollowVO> listS = netFollowService.followerList(fvo);
		logger.info("NetFollowController followerlist listS.size() >>> : " 
					+ listS.size());
		
		if(listS.size() != 0) {
			model.addAttribute("listS", listS);
			return "follow/followerlist";
		}
		return "follow/followerlistzero";
	}
	
	// 팔로우 중복 체크
	@RequestMapping(value="followcheck", method=RequestMethod.GET)
	@ResponseBody
	public String followcheck(HttpServletRequest req, HttpSession hs, NetFollowVO fvo) {
		logger.info("NetFollowController followcheck() 진입 >>> : ");
		
		// ajax 데이터 리턴에 사용할 변수 선언
		String msg = "";
		
		String follow_id = req.getParameter("follow_id");
		logger.info("팔로우한 ID >>>> : " + follow_id);
		
		// 회원번호 세션으로 불러오기
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String mb_id = mvo_data.getMb_id();
		logger.info("NetFollowController followcheck mb_id >>> : " + mb_id);
		
		// vo에 담기
		fvo.setMb_follow(follow_id);
		fvo.setMb_id(mb_id);
		
		List<NetFollowVO> followcheck = netFollowService.followcheck(fvo);
		logger.info("NetFollowController followcheck followcheck.size >>> : " 
					+ followcheck.size());
		
		// 이미 팔로우 중
		if(followcheck.size() != 0) {
			
			msg = "fail";
		
		// 중복 없음
		}else if(followcheck.size() == 0){
			msg = "success";
		}
		
		return msg;
	}
	
	// 팔로우 및 팔로워 추가
	@RequestMapping(value="addFollow", method=RequestMethod.GET)
	public String addFollow(HttpServletRequest req, NetFollowVO fvo, 
							Model model, HttpSession hs) {
		logger.info("NetFollowController addFollow() 진입 >>> : ");
		
		// 넘어온 데이터 확인
		String mb_follow = req.getParameter("follow_id");
		String follow_photo = req.getParameter("follow_photo");
		logger.info("NetFollowController addFollow 팔로우할 회원 id >>> : " 
					+ mb_follow);
		logger.info("NetFollowController addFollow 팔로우할 회원 사진 >>> : " 
					+ follow_photo);
		
		// 회원번호 세션으로 불러오기
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String mb_id = mvo_data.getMb_id();
		String mb_photo = mvo_data.getMb_photo();
		
		logger.info("NetFollowController addFollow mb_id >>> : " + mb_id);
		logger.info("NetFollowController addFollow mb_photo >>> : " + mb_photo);
		
		// vo에 세팅
		fvo.setMb_follow(mb_follow);
		fvo.setFollow_photo(follow_photo);
		fvo.setMb_id(mb_id);
		fvo.setMb_photo(mb_photo);
		
		// 팔로우 추가
		netFollowService.followInsert(fvo);
		// 팔로워 추가
		netFollowService.followerInsert(fvo);
		
		return "follow/followsuccess";
		
		/*
		 * int fwinsert = netFollowService.followInsert(fvo);
		 * model.addAttribute("fwinsert", fwinsert); 
		 * return "follow/followsuccess1";
		 */
	}
	
	// 팔로우 및 팔로워 삭제
	@RequestMapping(value="delFollow", method=RequestMethod.GET)
	public String delFollow(HttpServletRequest req, NetFollowVO fvo, 
							Model model, HttpSession hs) {
		logger.info("NetFollowController delFollow() 진입 >>> : ");
		
		// 넘어온 데이터 확인
		String mb_follow = req.getParameter("follow_id");
		logger.info("NetFollowController delFollow 팔로우 취소할 회원 id >>> : " 
					+ mb_follow);
		
		// 회원번호 세션으로 불러오기
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String mb_id = mvo_data.getMb_id();
		
		logger.info("NetFollowController delFollow mb_id >>> : " + mb_id);
		
		// vo에 세팅
		fvo.setMb_follow(mb_follow);
		fvo.setMb_id(mb_id);
		
		// 팔로우 추가
		netFollowService.followDelete(fvo);
		// 팔로워 추가
		netFollowService.followerDelete(fvo);
		
		return "follow/followdelete";
	}
	
}
