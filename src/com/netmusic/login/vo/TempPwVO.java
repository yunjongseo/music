package com.netmusic.login.vo;

import org.apache.log4j.Logger;

public class TempPwVO {
	private static Logger logger = Logger.getLogger(TempPwVO.class);
	
	private String pnum;
	private String ptemppw;
	private String mb_id;
	private String mb_insdate;
	
	public TempPwVO() {

	}
	
	public TempPwVO(String pnum, String ptemppw, 
					String mb_id, String mb_insdate) {
		this.pnum = pnum;
		this.ptemppw = ptemppw;
		this.mb_id = mb_id;
		this.mb_insdate = mb_insdate;
	}

	// getter
	public static Logger getLogger() {
		return logger;
	}
	public String getPnum() {
		return pnum;
	}
	public String getPtemppw() {
		return ptemppw;
	}
	public String getMb_id() {
		return mb_id;
	}
	public String getMb_insdate() {
		return mb_insdate;
	}
	
	// setter
	public static void setLogger(Logger logger) {
		TempPwVO.logger = logger;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public void setPtemppw(String ptemppw) {
		this.ptemppw = ptemppw;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public void setMb_insdate(String mb_insdate) {
		this.mb_insdate = mb_insdate;
	}
	
	// 매개변수 확인
	public static void printVO(TempPwVO tvo) {
		logger.info("TempPwVO printVO 데이터 확인 시작 >>> : ");
		
		logger.info("tvo.getPnum() >>> : " + tvo.getPnum());
		logger.info("tvo.getPtemppw() >>> : " + tvo.getPtemppw());
		logger.info("tvo.getMb_id() >>> : " + tvo.getMb_id());
		logger.info("입력일 >>> : " + tvo.getMb_insdate());
	}
}
