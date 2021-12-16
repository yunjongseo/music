package com.netmusic.common;

public class ChabunUtil {
	
	public static final String BIZ_GUBUN_M = "M"; // 회원 : MEMBER
	
	public static String numPad(String t, String c) {
			
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	public static String getMemChabun(String type, String memNum) {
		System.out.println("ChabunUtil getMemChabun() 함수 진입 >>> : ");
		
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, memNum));
	}
}
