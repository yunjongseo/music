package com.netmusic.login.vo;

public class NetLoginVO {

	private String mb_id;
	private String mb_pw;
	private	String mb_num;
	
	// 생성자
	public NetLoginVO() {

	}
	
	public NetLoginVO(String mb_id, String mb_pw, String mb_num) {

		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_num = mb_num;
	}

	// getter
	public String getMb_id() {
		return mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public String getMb_num() {
		return mb_num;
	}
	
	// setter
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public void setMb_num(String mb_num) {
		this.mb_num = mb_num;
	}
	
}
