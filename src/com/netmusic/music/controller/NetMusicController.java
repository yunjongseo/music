package com.netmusic.music.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netmusic.common.ChabunUtil;
import com.netmusic.common.CommonUtils;
import com.netmusic.common.FileUploadUtil;
import com.netmusic.common.service.ChabunService;
import com.netmusic.login.controller.NetLoginController;
import com.netmusic.login.vo.NetLoginVO;
import com.netmusic.member.vo.NetMemberVO;
import com.netmusic.music.service.NetMusicService;
import com.netmusic.music.vo.NetMusicVO;

@Controller
public class NetMusicController {
	Logger logger = Logger.getLogger(NetMusicController.class);
	
	private NetMusicService netMusicService;
	private ChabunService chabunService;
	
	// 생성자 오토와이어드
	@Autowired(required=false)
	public NetMusicController(NetMusicService netMusicService,
							  ChabunService chabunService) {
		this.netMusicService = netMusicService;
		this.chabunService = chabunService;
	}
	
	// 음원 정보 입력 폼
	@GetMapping("musicForm")
	public String musicForm() {
		logger.info("NetMusicController musicForm() 진입 >>> : ");
		
		return "music/musicForm";
	}
	
	// 음원 등록
	@RequestMapping(value="musicInsert", method=RequestMethod.POST)
	public String musicInsert(HttpServletRequest req, HttpSession hs) {
		logger.info("NetMusicController musicInsert() 진입 >>> : ");
		
		// 채번 구하기
		String ms_num = ChabunUtil.getMusicChabun(
						"D", chabunService.getMusicChabun().getMs_num());
		logger.info("NetMusicController musicInsert ms_num >>> : " + ms_num);
		
		// 회원번호 세션으로 불러오기
		NetMemberVO mvo_data = (NetMemberVO)hs.getAttribute("result"); 
		String mb_num = mvo_data.getMb_num();
		
		logger.info("NetMusicController musicInsert mb_num >>> : " + mb_num);
		
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.MUSIC_IMG_UPLOAD_PATH
									           	,CommonUtils.MUSIC_IMG_FILE_SIZE
									           	,CommonUtils.MUSIC_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		// boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절 하기 
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("NetMusicController musicInsert bool >>> : " + bool);
		
		// 채번, 이미지 업로드 성공하면 VO 세팅하기 
		NetMusicVO mvo = null;
		mvo = new NetMusicVO();
		
		// 음원 등록 번호
		mvo.setMs_num(ms_num);
		// 회원번호
		mvo.setMb_num(mb_num);
		// 장르
		mvo.setMs_genre(fu.getParameter("ms_genre1"));
		// 앨범명
		mvo.setMs_album(fu.getParameter("ms_album"));
		// 곡명
		mvo.setMs_name(fu.getParameter("ms_name"));
		// 국가명
		mvo.setMs_nation(fu.getParameter("ms_nation1"));
		// 가수명
		mvo.setMs_singer(fu.getParameter("ms_singer"));
		// 작곡가명
		mvo.setMs_composer(fu.getParameter("ms_composer"));
		// 발매일
		String ms_release = fu.getParameter("ms_release");
		String ms_release1 = fu.getParameter("ms_release1");
		String ms_release2 = fu.getParameter("ms_release2");
		ms_release = ms_release + ms_release1 + ms_release2;
		mvo.setMs_release(ms_release);
		// PlayTime
		String ms_playtime1 = fu.getParameter("ms_playtime1");
		String ms_playtime2 = fu.getParameter("ms_playtime2");
		ms_playtime1 = ms_playtime1 + ms_playtime2;
		mvo.setMs_playtime(ms_playtime1);
		// 앨범 사진
		ArrayList<String> aFileName = fu.getFileNames();
		String ms_photo = aFileName.get(0);				
		mvo.setMs_photo(ms_photo);	
		// 음원
		ArrayList<String> aFileName1 = fu.getFileNames();
		String ms_music = aFileName1.get(0);				
		mvo.setMs_music(ms_music);
		
		int nCnt = netMusicService.musicInsert(mvo);
			
		if (nCnt > 0) { return "music/musicInsertSuccess";}
		return "";
	}
}
