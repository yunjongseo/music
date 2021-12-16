package com.netmusic.login.vo;

import org.apache.log4j.Logger;

public class TempAuthNumVO {
	private static Logger logger = Logger.getLogger(TempAuthNumVO.class);
	
	private int anum;
	private String authnum;
	private String mb_email;
	private String mb_insdate;
	
	public TempAuthNumVO() {

	}
	
	public TempAuthNumVO(int anum, String authnum, 
						 String mb_email, String mb_insdate) {

		this.anum = anum;
		this.authnum = authnum;
		this.mb_email = mb_email;
		this.mb_insdate = mb_insdate;
	}

	// getter
	public static Logger getLogger() {
		return logger;
	}
	public int getAnum() {
		return anum;
	}
	public String getAuthnum() {
		return authnum;
	}
	public String getMb_email() {
		return mb_email;
	}
	public String getMb_insdate() {
		return mb_insdate;
	}
	
	// setter
	public static void setLogger(Logger logger) {
		TempAuthNumVO.logger = logger;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public void setAuthnum(String authnum) {
		this.authnum = authnum;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public void setMb_insdate(String mb_insdate) {
		this.mb_insdate = mb_insdate;
	}
	
	// 매개변수 확인
	public static void printVO(TempAuthNumVO tvo) {
		logger.info("TempAythNumVO printVO 데이터 확인 시작 >>> : ");
		
		logger.info("인증번호 시퀀스 >>> : " + tvo.getAnum());
		logger.info("인증번호 >>> : " + tvo.getAuthnum());
		logger.info("인증 이메일 >>> : " + tvo.getMb_email());
		logger.info("입력일 >>> : " + tvo.getMb_insdate());
	}
}
