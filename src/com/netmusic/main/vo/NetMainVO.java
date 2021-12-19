package com.netmusic.main.vo;

public class NetMainVO {

	// 검색 구분자 및 검색어
	private String keyfilter;
	private String keyword;
	private String startdate;
	private String enddate;
	
	public NetMainVO() {

	}
	
	public NetMainVO(String keyfilter, String keyword, 
					 String startdate, String enddate) {

		this.keyfilter = keyfilter;
		this.keyword = keyword;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public String getKeyfilter() {
		return keyfilter;
	}
	public String getKeyword() {
		return keyword;
	}
	public String getStartdate() {
		return startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setKeyfilter(String keyfilter) {
		this.keyfilter = keyfilter;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}
