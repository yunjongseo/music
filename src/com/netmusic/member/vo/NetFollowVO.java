package com.netmusic.member.vo;

public class NetFollowVO {

	private String mb_id;
	private String mb_follow;
	private String mb_insdate;
	private String mb_upddate;
	private String mb_delyn;
	
	public NetFollowVO() {

	}
	
	public NetFollowVO(String mb_id, String mb_follow, String mb_insdate, 
					   String mb_upddate, String mb_delyn) {

		this.mb_id = mb_id;
		this.mb_follow = mb_follow;
		this.mb_insdate = mb_insdate;
		this.mb_upddate = mb_upddate;
		this.mb_delyn = mb_delyn;
	}

	public String getMb_id() {
		return mb_id;
	}
	public String getMb_follow() {
		return mb_follow;
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
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public void setMb_follow(String mb_follow) {
		this.mb_follow = mb_follow;
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
	
	
}
