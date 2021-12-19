package com.netmusic.login.dao;

import java.util.List;

import com.netmusic.login.vo.NetLoginVO;
import com.netmusic.login.vo.TempAuthNumVO;
import com.netmusic.login.vo.TempPwVO;
import com.netmusic.member.vo.NetMemberVO;

public interface NetLoginDAO {

	public List<NetLoginVO> loginCheck(NetLoginVO lvo);
	
	// 이메일로 ID 찾기
	// 1. 이메일 체크
	public List<NetMemberVO> emailCheck(NetMemberVO mvo);
	// 2. 인증번호 입력  : TEMP_AUTH_NUM 테이블
	public int tempAuthNumInsert(TempAuthNumVO tvo);
	// 3. 이메일 및 인증번호로 아이디 찾기
	public List<NetMemberVO> emailIdFind(NetMemberVO mvo);
	
	// 아이디로 비밀번호 찾기
	// 1. 아이디 체크
	public List<NetMemberVO> pwIdCheck(NetMemberVO mvo);
	// 2. 이메일 체크
	public List<NetMemberVO> pwEmailCheck(NetMemberVO mvo);
	// 3. 임시 비밀번호 임력 : TEMP_PW 테이블
	public int tempPwInsert(TempPwVO tvo);
	public int pwUpdate(NetMemberVO mvo);
}
