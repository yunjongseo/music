package com.netmusic.member.controller;

import java.util.ArrayList;
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

import com.netmusic.common.ChabunUtil;
import com.netmusic.common.CommonUtils;
import com.netmusic.common.FileUploadUtil;
import com.netmusic.common.service.ChabunService;
import com.netmusic.member.service.NetMemberService;
import com.netmusic.member.vo.NetMemberVO;

@Controller
public class NetMemberController {
	Logger logger = Logger.getLogger(NetMemberController.class);
	
	private NetMemberService netMemberService;
	private ChabunService chabunService;
	
	// 생성자 오토와이어드 
	@Autowired(required=false)	
	public NetMemberController( NetMemberService netMemberService
			               		 ,ChabunService chabunService) {
		this.netMemberService = netMemberService;
		this.chabunService = chabunService;
	}
			
	// 회원가입 입력 폼
	@GetMapping("memForm")
	public String boardForm() {		
		return "member/memberForm";
	}
	
	// 회원가입 
	@RequestMapping(value="memInsert", method=RequestMethod.POST)
	public String memInsert(HttpServletRequest req) {
		logger.info("NetMemberController memInsert() 진입 >>> : ");
		
		// 채번 구하기
		String mb_num = ChabunUtil.getMemChabun("D", chabunService.getMemChabun().getMb_num());
		logger.info("NetMemberController memInsert mb_num >>> : " + mb_num);
		
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.MEMBER_IMG_UPLOAD_PATH
									           	,CommonUtils.MEMBER_IMG_FILE_SIZE
									           	,CommonUtils.MEMBER_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		// boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절 하기 
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("NetMemberController memInsert bool >>> : " + bool);
		
		// 채번, 이미지 업로드 성공하면 VO 세팅하기 
		NetMemberVO mvo = null;
		mvo = new NetMemberVO();
		
		// 회원번호
		mvo.setMb_num(mb_num);
		// 아이디
		mvo.setMb_id(fu.getParameter("mb_id"));
		// 패스워드
		mvo.setMb_pw(fu.getParameter("mb_pw"));
		// 회원이름
		mvo.setMb_name(fu.getParameter("mb_name"));
		// 성별
		mvo.setMb_gender(fu.getParameter("mb_gender"));
		// 생년월일
		String mb_birth = fu.getParameter("mb_birth");
		String mb_birth1 = fu.getParameter("mb_birth1");
		String mb_birth2 = fu.getParameter("mb_birth2");
		mb_birth = mb_birth + mb_birth1 + mb_birth2;
		mvo.setMb_birth(mb_birth);
		// 핸드폰
		mvo.setMb_hp(fu.getParameter("mb_hp"));
		// 이메일
		String mb_email = fu.getParameter("mb_email");
		String mb_email1 = fu.getParameter("mb_email1");
		mb_email = mb_email.concat("@").concat(mb_email1);
		mvo.setMb_email(mb_email);
		// 사진
		ArrayList<String> aFileName = fu.getFileNames();
		String mb_photo = aFileName.get(0);				
		mvo.setMb_photo(mb_photo);		
		// 음악 취향
		String[] liking = fu.getparameterValues("mb_liking");
		String mb_liking = "";
		for(int i=0; i < liking.length; i++) {
			mb_liking += liking[i] + " ";
		}
		mvo.setMb_liking(mb_liking);

		netMemberService.memberInsert(mvo);
		
		/*
		int nCnt = netMemberService.memberInsert(mvo);
		 	if (nCnt > 0) { return "login/loginForm";} return "";
		 */
		return "login/loginForm";
	}
	
	// 아이디 중복 체크하기
	@RequestMapping(value="memIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object memIdCheck(NetMemberVO mvo) {
		logger.info("NetMemberController memIdCheck 진입  >>> :");		
		logger.info("NetMemberController memIdCheck mvo.getMb_id() >>> : " + mvo.getMb_id());			
		

		List<NetMemberVO> list = netMemberService.memberIdCheck(mvo);			
		logger.info("NetMemberController memIdCheck list.size() >>> : " + list.size());
		
		String msg = "";		
		if (list.size() == 0) {msg = "ID_YES";}  
		else { msg = "ID_NO";}  
		
		return msg;		
	}
	
	// 회원 전체 조회
	@RequestMapping(value="memberSelectAll", method=RequestMethod.GET)
	public String memberSelectAll(NetMemberVO mvo, Model model, HttpSession hs) {
		logger.info("NetMemberController memberSelectAll() 진입 >>> : ");
		
		logger.info("NetMemberController memberSelectAll() 진입 >>> : "
				+ "검색 관련 로그 ==========");
		logger.info("NetMemberController memberSelectAll bvo.getKeyfilter() >>> : " 
						+ mvo.getKeyfilter());
		logger.info("NetMemberController memberSelectAll bvo.getKeyword() >>> : " 
						+ mvo.getKeyword());
		
		// 로그인한 회원 아이디 세션으로 불러오기
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String my_id = mvo_data.getMb_id();
		logger.info("NetFollowController memberSelectAll my_id >>> : " + my_id);
		
		mvo.setMy_id(my_id);

		List<NetMemberVO> listAll = netMemberService.memberSelectAll(mvo);
		logger.info("NetMemberController memberSelectAll listAll.size() >>> : " 
					+ listAll.size());
			
		model.addAttribute("listAll", listAll);
		return "member/memberSelectAll";
	}
	
	// 회원 조건 조회
	@RequestMapping(value="memberSelect", method=RequestMethod.GET)
	public String memberSelect(NetMemberVO mvo, Model model, HttpSession hs) {
		logger.info("NetMemberController memberSelect() 진입 >>> : ");
		logger.info("NetMemberController memberSelect mvo.getMb_num() >>> : "
					+ mvo.getMb_num());
		
		// 로그인한 회원 아이디 세션으로 불러오기
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String my_id = mvo_data.getMb_id();
		logger.info("NetFollowController memberSelectAll my_id >>> : " + my_id);
		
		mvo.setMy_id(my_id);
				
		List<NetMemberVO> listS = netMemberService.memberSelect(mvo);
		logger.info("NetMemberController memberSelect listS.size() >>> : " +
		listS.size());

		model.addAttribute("listS", listS);
		return "member/memberSelect";
	}
}
