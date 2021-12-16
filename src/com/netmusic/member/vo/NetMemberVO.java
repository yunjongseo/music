package com.netmusic.member.vo;

import org.apache.log4j.Logger;

public class NetMemberVO {
	private static Logger logger = Logger.getLogger(NetMemberVO.class);
	
	private String mb_num;
	private String mb_id;
	private String mb_pw;
	private String mb_name;
	private String mb_gender;
	private String mb_birth;
	private String mb_hp;
	private String mb_email;
	private String mb_photo;
	private String mb_liking;
	private String mb_insdate;
	private String mb_upddate;
	private String mb_delyn;
	
	// 생성자
	public NetMemberVO() {
	
	}
	
	public NetMemberVO(	String mb_num, String mb_id, String mb_pw, 
						String mb_name, String mb_gender, String mb_birth,
						String mb_hp, String mb_email, String mb_photo, 
						String mb_liking, String mb_insdate, String mb_upddate,
						String mb_delyn) {
		this.mb_num = mb_num;
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_name = mb_name;
		this.mb_gender = mb_gender;
		this.mb_birth = mb_birth;
		this.mb_hp = mb_hp;
		this.mb_email = mb_email;
		this.mb_photo = mb_photo;
		this.mb_liking = mb_liking;
		this.mb_insdate = mb_insdate;
		this.mb_upddate = mb_upddate;
		this.mb_delyn = mb_delyn;
	}

	// getter
	public String getMb_num() {
		return mb_num;
	}
	public String getMb_id() {
		return mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public String getMb_name() {
		return mb_name;
	}
	public String getMb_gender() {
		return mb_gender;
	}
	public String getMb_birth() {
		return mb_birth;
	}
	public String getMb_hp() {
		return mb_hp;
	}
	public String getMb_email() {
		return mb_email;
	}
	public String getMb_photo() {
		return mb_photo;
	}
	public String getMb_liking() {
		return mb_liking;
	}
	public String getMb_insdate() {
		return mb_insdate;
	}
	public String getMb_upddate() {
		return mb_upddate;
	}
	public String getMb_delyn() {
		return mb_delyn;
	}
	
	// setter
	public void setMb_num(String mb_num) {
		this.mb_num = mb_num;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public void setMb_gender(String mb_gender) {
		this.mb_gender = mb_gender;
	}
	public void setMb_birth(String mb_birth) {
		this.mb_birth = mb_birth;
	}
	public void setMb_hp(String mb_hp) {
		this.mb_hp = mb_hp;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public void setMb_photo(String mb_photo) {
		this.mb_photo = mb_photo;
	}
	public void setMb_liking(String mb_liking) {
		this.mb_liking = mb_liking;
	}
	public void setMb_insdate(String mb_insdate) {
		this.mb_insdate = mb_insdate;
	}
	public void setMb_upddate(String mb_upddate) {
		this.mb_upddate = mb_upddate;
	}
	public void setMb_delyn(String mb_delyn) {
		this.mb_delyn = mb_delyn;
	}
	
	// 매개변수 확인
	public static void printVO(NetMemberVO mvo) {
		logger.info("SugangVO printVO() 함수 진입 >>> : ");
		logger.info("printVO mvo >>> : " + mvo);
		logger.info("mb_num >>> : " + mvo.getMb_num());
		logger.info("mb_id >>> : " + mvo.getMb_id());
		logger.info("mb_pw >>> : " + mvo.getMb_pw());
		logger.info("mb_name >>> : " + mvo.getMb_name());
		logger.info("mb_gender >>> : " + mvo.getMb_gender());
		logger.info("mb_birth >>> : " + mvo.getMb_birth());
		logger.info("mb_hp >>> : " + mvo.getMb_hp());
		logger.info("mb_email >>> : " + mvo.getMb_email());
		logger.info("mb_photo >>> : " + mvo.getMb_photo());
		logger.info("mb_liking >>> : " + mvo.getMb_liking());
		logger.info("mb_insdate >>> : " + mvo.getMb_insdate());
		logger.info("mb_upddate >>> : " + mvo.getMb_upddate());
		logger.info("mb_delyn >>> : " + mvo.getMb_delyn());
	}
}
