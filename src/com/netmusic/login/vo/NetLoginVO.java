package com.netmusic.login.vo;

import org.apache.log4j.Logger;

public class NetLoginVO {
	private static Logger logger = Logger.getLogger(NetLoginVO.class);
	
	private String pnum;
	private String ptemppw;
	private String mb_id;
	private String mb_insdate;
	
	public NetLoginVO() {

	}
	
	public NetLoginVO(String pnum, String ptemppw, 
					  String mb_id, String mb_insdate) {
		this.pnum = pnum;
		this.ptemppw = ptemppw;
		this.mb_id = mb_id;
		this.mb_insdate = mb_insdate;
	}

	// getter
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
	public static void printVO(NetLoginVO lvo) {
		logger.info("NetLoginVO printVO 데이터 확인 시작 >>> : ");
		
		logger.info("lvo.getPnum() >>> : " + lvo.getPnum());
		logger.info("lvo.getPtemppw() >>> : " + lvo.getPtemppw());
		logger.info("lvo.getMb_id() >>> : " + lvo.getMb_id());
		logger.info("입력일 >>> : " + lvo.getMb_insdate());
	}
}
