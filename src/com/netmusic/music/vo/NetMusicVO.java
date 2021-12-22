package com.netmusic.music.vo;

public class NetMusicVO {

	private String ms_num;
	private String mb_num;
	private String ms_genre;
	private String ms_album;
	private String ms_name;
	private String ms_nation;
	private String ms_singer;
	private String ms_composer;
	private String ms_release;
	private String ms_playtime;
	private String ms_photo;
	private String ms_music;
	private String ms_insdate;
	private String ms_upddate;
	private String ms_delyn;
	
	// 생성자
	public NetMusicVO() {
	
	}
	
	public NetMusicVO(String ms_num, String mb_num, String ms_genre, 
					  String ms_album, String ms_name, String ms_nation, 
					  String ms_singer, String ms_composer, String ms_release, 
					  String ms_playtime, String ms_photo, String ms_music, 
					  String ms_insdate, String ms_upddate, String ms_delyn) {
	
		this.ms_num = ms_num;
		this.mb_num = mb_num;
		this.ms_genre = ms_genre;
		this.ms_album = ms_album;
		this.ms_name = ms_name;
		this.ms_nation = ms_nation;
		this.ms_singer = ms_singer;
		this.ms_composer = ms_composer;
		this.ms_release = ms_release;
		this.ms_playtime = ms_playtime;
		this.ms_photo = ms_photo;
		this.ms_music = ms_music;
		this.ms_insdate = ms_insdate;
		this.ms_upddate = ms_upddate;
		this.ms_delyn = ms_delyn;
	}

	// getter
	public String getMs_num() {
		return ms_num;
	}
	public String getMb_num() {
		return mb_num;
	}
	public String getMs_genre() {
		return ms_genre;
	}
	public String getMs_album() {
		return ms_album;
	}
	public String getMs_name() {
		return ms_name;
	}
	public String getMs_nation() {
		return ms_nation;
	}
	public String getMs_singer() {
		return ms_singer;
	}
	public String getMs_composer() {
		return ms_composer;
	}
	public String getMs_release() {
		return ms_release;
	}
	public String getMs_playtime() {
		return ms_playtime;
	}
	public String getMs_photo() {
		return ms_photo;
	}
	public String getMs_music() {
		return ms_music;
	}
	public String getMs_insdate() {
		return ms_insdate;
	}
	public String getMs_upddate() {
		return ms_upddate;
	}
	public String getMs_delyn() {
		return ms_delyn;
	}
	
	
	// setter
	public void setMs_num(String ms_num) {
		this.ms_num = ms_num;
	}
	public void setMb_num(String mb_num) {
		this.mb_num = mb_num;
	}
	public void setMs_genre(String ms_genre) {
		this.ms_genre = ms_genre;
	}
	public void setMs_album(String ms_album) {
		this.ms_album = ms_album;
	}
	public void setMs_name(String ms_name) {
		this.ms_name = ms_name;
	}
	public void setMs_nation(String ms_nation) {
		this.ms_nation = ms_nation;
	}
	public void setMs_singer(String ms_singer) {
		this.ms_singer = ms_singer;
	}
	public void setMs_composer(String ms_composer) {
		this.ms_composer = ms_composer;
	}
	public void setMs_release(String ms_release) {
		this.ms_release = ms_release;
	}
	public void setMs_playtime(String ms_playtime) {
		this.ms_playtime = ms_playtime;
	}
	public void setMs_photo(String ms_photo) {
		this.ms_photo = ms_photo;
	}
	public void setMs_music(String ms_music) {
		this.ms_music = ms_music;
	}
	public void setMs_insdate(String ms_insdate) {
		this.ms_insdate = ms_insdate;
	}
	public void setMs_upddate(String ms_upddate) {
		this.ms_upddate = ms_upddate;
	}
	public void setMs_delyn(String ms_delyn) {
		this.ms_delyn = ms_delyn;
	}
}
