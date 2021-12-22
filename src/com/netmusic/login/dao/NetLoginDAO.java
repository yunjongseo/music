package com.netmusic.login.dao;

import java.util.List;

import com.netmusic.login.vo.NetLoginVO;
import com.netmusic.member.vo.NetMemberVO;

public interface NetLoginDAO {

	public List<NetMemberVO> loginCheck(NetMemberVO mvo);
	
	// ID 찾기
	public List<NetMemberVO> idCheck(NetMemberVO mvo);
	
	// 비밀번호 찾기
	// 1. 아이디 및 이메일 체크
	public List<NetMemberVO> pwIdCheck(NetMemberVO mvo);
	// 2. 임시 비밀번호 임력 : TEMP_PW 테이블
	public int tempPwInsert(NetLoginVO lvo);
	public int pwUpdate(NetMemberVO mvo);
}
