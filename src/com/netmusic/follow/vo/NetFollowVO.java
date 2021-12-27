package com.netmusic.follow.vo;

public class NetFollowVO {

	private String mb_id; // 내 아이디
	private String mb_photo; // 내 사진
	private String mb_name;
	private String mb_follow; // 팔로우할 회원 아이디
	private	String follow_photo; // 팔로우할 회원 사진
	private String mb_insdate;
	private String mb_upddate;
	private String mb_delyn;
	private String follower_id; // 나를 팔로우한 회원의 아이디
	private String follower_photo; // 나를 팔로우한 회원의 사진
	
	// 생성자
	public NetFollowVO() {

	}
	
	public NetFollowVO(String mb_id, String mb_name, String mb_follow, 
					   String mb_insdate, String mb_upddate, String mb_delyn,
					   String follow_photo, String mb_photo, String follower_id,
					   String follower_photo) {

		this.mb_id = mb_id;
		this.mb_photo = mb_photo;
		this.mb_name = mb_name;
		this.mb_follow = mb_follow;
		this.mb_follow = follow_photo;
		this.mb_insdate = mb_insdate;
		this.mb_upddate = mb_upddate;
		this.mb_delyn = mb_delyn;
		this.follower_id = follower_id;
		this.follower_photo = follower_photo;
	}

	// getter
	public String getMb_id() {
		return mb_id;
	}
	public String getMb_photo() {
		return mb_photo;
	}
	public String getMb_name() {
		return mb_name;
	}
	public String getFollow_photo() {
		return follow_photo;
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
	public String getFollower_id() {
		return follower_id;
	}
	public String getFollower_photo() {
		return follower_photo;
	}
	
	// setter
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public void setMb_photo(String mb_photo) {
		this.mb_photo = mb_photo;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public void setMb_follow(String mb_follow) {
		this.mb_follow = mb_follow;
	}
	public void setFollow_photo(String follow_photo) {
		this.follow_photo = follow_photo;
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
	public void setFollower_id(String follower_id) {
		this.follower_id = follower_id;
	}
	public void setFollower_photo(String follower_photo) {
		this.follower_photo = follower_photo;
	}
}
