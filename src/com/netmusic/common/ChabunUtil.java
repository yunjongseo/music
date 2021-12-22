package com.netmusic.common;

public class ChabunUtil {
	
	public static final String BIZ_GUBUN_M = "M"; // 회원 : MEMBER
	public static final String BIZ_GUBUN_A = "A"; // 음원 : MUSIC
	
	public static String numPad(String t, String c) {
			
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	// 회원 번호
	public static String getMemChabun(String type, String memNum) {
		System.out.println("ChabunUtil getMemChabun() 함수 진입 >>> : ");
		
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, memNum));
	}
	
	// 음원 등록 번호
	public static String getMusicChabun(String type, String memNum) {
		System.out.println("ChabunUtil getMusicChabun() 함수 진입 >>> : ");
		
		return BIZ_GUBUN_A.concat(ChabunUtil.numPad(type, memNum));
	}
}
